
public enum MediaType {
	DVD(0), BluRay(1);
	private int value;
	MediaType(int value) {this.value = value;}
	public int getValue(){return this.value;}
}
