
public enum RentalPeriod {
	n2d3(2), n7d8(7);
	private int value;
	RentalPeriod(int value) {this.value = value;}
	public int getValue(){return this.value;}
}
