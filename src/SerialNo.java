import java.text.DecimalFormat;

public class SerialNo {
	private int lastNumber = 0;
	private String prefix = "";
	private int digits = 6;
	public int getLastNumber(){return lastNumber;}
	public synchronized int getNextNumber(){return ++lastNumber;}
	public String getNextId(){
		String format = "0000000000000000000000".substring(0, digits);
		DecimalFormat fmt = new DecimalFormat(format);
		return this.prefix + fmt.format(this.getNextNumber());
	}
	public SerialNo(String prefix,int digits){
		this.prefix = prefix;
		this.digits = digits;
	}
}
