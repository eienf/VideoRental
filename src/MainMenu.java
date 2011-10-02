
public class MainMenu extends Menu {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ObjectStore.getInstance().load();
		TestData.load();
		MainMenu mainMenu = new MainMenu();
		mainMenu.run();
	}

	public void run() {
		Finish:
		while ( true ) {
			Menu menu = null;
			printMessage("1)‘İo 2)•Ô‹p 3)‰ïˆõ“o˜^ 4)“Xˆõ“o˜^ 5)“ú•tİ’è 9)I—¹");
			printString(":-? ");
			int no = readInt();
			switch ( no ) {
			case 1:
				menu = new D1Rental();
				menu.run();
				break;
			case 2:
				menu = new D2Return();
				menu.run();
				break;
			case 3:
				menu = new D3MemberRegist();
				menu.run();
				break;
			case 4:
				menu = new D4StaffRegist();
				menu.run();
				break;
			case 5:
				menu = new D5RegisterSetting();
				menu.run();
				break;
			case 9:
				break Finish;
			}			
		}			
	printMessage("END PROGRAM. THANK YOU.");
	}

	public  void initialize() {}
	public  void finalize() {}
	public  String openingMessage() {return "";}
	public  String promptMessage() {return "";}
	public  boolean runSeaquence() {return false;}

}
