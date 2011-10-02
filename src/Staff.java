
public class Staff {
	private String name;
	private String identifier;
	private static SerialNo serialNo = new SerialNo("S",3);
	public Staff(String name){
		this.name = name;
		this.identifier = serialNo.getNextId();
	}
	public String getIdentifier() {return this.identifier;}
	public String getName() {return this.name;}
	public void setName(String name){this.name = name;}
	public String toString(){return "Staff:"+this.identifier+","+this.name;}
	
}
