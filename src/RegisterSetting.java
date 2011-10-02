import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class RegisterSetting {
	private static Date today = new Date();
	private static SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
	public static void setToday(String str){
		try {
			Date theDate = fmt.parse(str);
			today = theDate;
		} catch (ParseException e) {
			System.err.println("Format error: "+str);
		}
	}
	public static String getTodayString(){
		return date2string(today);
	}
	public static void setToday(Date theDate){
		today = theDate;
	}
	public static Date getToday() {
		return today;
	}
	public static String date2string(Date date){
		return fmt.format(date);
	}
}
