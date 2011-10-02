import java.util.HashSet;
import java.util.Set;


public class Member {
	private String name;
	private String identifier;
	private static SerialNo serialNo = new SerialNo("M",5);
	private Set<Rental> rentalList;
	
	public Member(String name){
		this.name = name;
		this.identifier = serialNo.getNextId();
		rentalList = new HashSet<Rental>();
	}
	public String getIdentifier() {return this.identifier;}
	public String getName() {return this.name;}
	public void setName(String name){this.name = name;}
	public String toString(){return "Member:"+this.identifier+","+this.name;}
	public boolean beInRental(){
		for (Rental rental : rentalList ) {
			if ( rental.beInRental() ) return true;
		}
		return false;
	}
	public void addToRentalList(Rental rental) {
		rentalList.add(rental);
	}
}
