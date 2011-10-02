
public class RentalDetail {
	private Rental rental;
	private VideoEntity entity;
	private int rentalCharge;
	public RentalDetail(Rental rental,VideoEntity entity){
		this.rental = rental;
		this.entity = entity;
	}
	public void calcRentalCharge(RentalPeriod period){
		MediaType media = entity.getTitle().mediaType();
		int price = PriceCalc.rentalPrice(media, period);
		this.rentalCharge = price;
	}
	public int getRentalCharge() {
		return rentalCharge;
	}
	public void setRentalCharge(int rentalCharge) {
		this.rentalCharge = rentalCharge;
	}
	public VideoEntity getVideoEntity() {
		return this.entity;
	}
	public Rental getRental() {
		return rental;
	}
}
