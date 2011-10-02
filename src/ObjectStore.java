import java.util.HashMap;

public class ObjectStore {
	private static final ObjectStore instance = new ObjectStore();
	private HashMap<String,Staff> staffList;
	private HashMap<String,Member> memberList;
	private HashMap<String,VideoTitle> titleList;
	private HashMap<String,VideoEntity> goodsList;
	private HashMap<String,Rental> rentalList;
	private ObjectStore() {};
	public void load() {
		if ( staffList == null ) {
			staffList = new HashMap<String,Staff>();
		}
		if ( memberList == null ) {
			memberList = new HashMap<String,Member>();
		}
		if ( titleList == null ) {
			titleList = new HashMap<String,VideoTitle>();
		}
		if ( goodsList == null ) {
			goodsList = new HashMap<String,VideoEntity>();
		}
		if ( rentalList == null ) {
			rentalList = new HashMap<String,Rental>();
		}
	}
	public static ObjectStore getInstance() {
		return instance;
	}
	public void saveStaff(Staff staff){
		staffList.put(staff.getIdentifier(),staff);
	}
	public Staff getStaff(String identifier){
		return staffList.get(identifier);
	}
	public int numberOfStaff(){
		return staffList.size();
	}
	public void saveMember(Member object){
		memberList.put(object.getIdentifier(),object);
	}
	public Member getMember(String identifier){
		return memberList.get(identifier);
	}
	public int numberOfMember(){
		return memberList.size();
	}
	public void saveVideoTitle(VideoTitle object){
		titleList.put(object.getIdentifier(),object);
	}
	public VideoTitle getVideoTitle(String identifier){
		return titleList.get(identifier);
	}
	public int numberOfVideoTitle(){
		return titleList.size();
	}
	public void saveVideoEntity(VideoEntity object){
		goodsList.put(object.getIdentifier(),object);
	}
	public VideoEntity getVideoEntity(String identifier){
		return goodsList.get(identifier);
	}
	public int numberOfVideoEntity(){
		return goodsList.size();
	}
	public void saveRental(Rental object){
		rentalList.put(object.getIdentifier(),object);
	}
	public Rental getRental(String identifier){
		return rentalList.get(identifier);
	}
	public int numberOfRental(){
		return rentalList.size();
	}
}
