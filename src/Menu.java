import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Menu {
	public abstract void initialize();
	public abstract void finalize();
	public abstract String openingMessage();
	public abstract String promptMessage();
	public abstract boolean runSeaquence();
	public void run() {
		initialize();
		printMessage(this.openingMessage());
		boolean flag = true;
		while(flag){
			flag = runSeaquence();
		}
		finalize();
	}
	/**
	 * @param args
	 */
	public static int readInt() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return Integer.parseInt(br.readLine());
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * @param args
	 */
	public static String readString() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return br.readLine();
		} catch (IOException e) {
			return "";
		}
	}

	public static void printMessage(String str) {
		System.out.println(str);
	}

	public static void printString(String str) {
		System.out.print(str);
	}

}
