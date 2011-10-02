import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Rental {
	private static SerialNo serialNo = new SerialNo("R",6);
	private String identifier;
	private Set<RentalDetail> detailList;
	private Date rentalDate;
	private RentalPeriod rentalPeriod;
	private Date returnDate;
	private int extraCharge;
	private int rentalCharge;
	private Staff staff;
	private Member member;
	
	public Rental(){
		this.identifier = serialNo.getNextId();
		detailList = new HashSet<RentalDetail>();
	}
	public String getIdentifier() {return this.identifier;}
	public Date getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}
	public RentalPeriod getRentalPeriod() {
		return rentalPeriod;
	}
	public void setRentalPeriod(RentalPeriod rentalPeriod) {
		this.rentalPeriod = rentalPeriod;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public int getExtraCharge() {
		return extraCharge;
	}
	public void setExtraCharge(int extraCharge) {
		this.extraCharge = extraCharge;
	}
	public int getRentalCharge() {
		return rentalCharge;
	}
	public void setRentalCharge(int rentalCharge) {
		this.rentalCharge = rentalCharge;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String toString(){return "Rental:"+this.identifier;}
	public boolean beInRental(){
		return rentalDate != null && returnDate == null;
	}
	public boolean addVideoEntity(String entityId){
		VideoEntity entity = ObjectStore.getInstance().getVideoEntity(entityId);
		if ( entity == null ) return false;
		return this.addVideoEntity(entity);
	}
	public boolean contains(VideoEntity entity) {
		for ( RentalDetail detail : detailList ) {
			if ( detail.getVideoEntity().getIdentifier().equals(entity.getIdentifier()) ) {
				return true;
			}
		}
		return false;
	}
	public boolean addVideoEntity(VideoEntity entity){
		if ( entity.isInRental() ) return false;
		if ( this.contains(entity) ) return false;
		if ( detailList.size() >= 5) return false;
		RentalDetail detail = new RentalDetail(this,entity);
		detailList.add(detail);
		return true;
	}
	public void calcRentalCharge(){
		int price = 0;
		for ( RentalDetail detail : detailList ){
			detail.calcRentalCharge(this.rentalPeriod);
			price += detail.getRentalCharge();
		}
		rentalCharge = price;
	}
	public int numberOfDetail() { return detailList.size();}
	public boolean isOverNights() {
		Date today = RegisterSetting.getToday();
		Date deadline = this.getScheduledReturn();
		if ( today.after(deadline) ) return true;
		return false;
	}
	public int overNights() {
		Calendar today = Calendar.getInstance();
		today.setTime(RegisterSetting.getToday());
		today.set(Calendar.HOUR, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);
		Calendar deadline = Calendar.getInstance();
		deadline.setTime(this.getScheduledReturn());
		deadline.set(Calendar.HOUR, 0);
		deadline.set(Calendar.MINUTE, 0);
		deadline.set(Calendar.SECOND, 0);
		deadline.set(Calendar.MILLISECOND, 0);
		long diff = (today.getTimeInMillis() - deadline.getTimeInMillis())/(24*60*60*1000);
		return (int)diff;
	}
	public void calcExtraCharge(){
		int price = 0;
		if ( this.isOverNights() ) {
			price = detailList.size() * PriceCalc.extraCharge() * this.overNights();
		}
		this.setExtraCharge(price);
	}
	protected void setInRentalFlag(boolean flag){
		for ( RentalDetail detail : detailList ) {
			VideoEntity entity = detail.getVideoEntity();
			entity.setInRental(flag);
		}
	}
	public void didFixRental(){
		member.addToRentalList(this);
		this.rentalDate = RegisterSetting.getToday();
		this.setInRentalFlag(true);
	}
	public void didFixReturn(){
		this.returnDate = RegisterSetting.getToday();
		this.setInRentalFlag(false);
	}
	public Date getScheduledReturn() {
	    Calendar cal1 = Calendar.getInstance();
	    cal1.setTime(this.rentalDate);
	    cal1.add(Calendar.DATE, this.getRentalPeriod().getValue());
		return cal1.getTime();
	}
	public String getReceipt() {
		String cr = System.getProperty("line.separator");
		StringBuffer sb = new StringBuffer();
		sb.append("ID : "+this.getIdentifier()+cr);
		sb.append("Member : "+member.getName() + " " + member.getIdentifier() + cr);
		sb.append("Staff : "+staff.getName() + " " + staff.getIdentifier() + cr);
		sb.append("Rental Date : "+RegisterSetting.date2string(this.getRentalDate()) + cr);
		sb.append("Period : " + this.getRentalPeriod().getValue() + " nights"+ cr);
		sb.append("Scheduled Return : " + RegisterSetting.date2string(this.getScheduledReturn()) + cr);
		sb.append("Item number : "+this.numberOfDetail()+cr);
		sb.append("Rental Charge : "+this.getRentalCharge()+cr);
		for ( RentalDetail detail : detailList ) {
			VideoEntity entity = detail.getVideoEntity();
			VideoTitle title = entity.getTitle();
			MediaType type = title.mediaType();
			sb.append("> "+entity.getIdentifier() + " " +title.getName());
			if ( type == MediaType.DVD ) {
				sb.append("[DVD] ");
			} else if ( type == MediaType.BluRay ) {
				sb.append("[BluRay]");
			}
			sb.append(" "+detail.getRentalCharge()+cr);
		}
		return sb.toString();
	}
}
