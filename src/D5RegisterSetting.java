
public class D5RegisterSetting extends Menu {
	public D5RegisterSetting() {
	}
	public void initialize() {}
	public void finalize() {}

	@Override
	public String openingMessage() {
		return "*** Register Setting ***";
	}

	@Override
	public String promptMessage() {
		return "input Date(YYYY/MM/DD) or return to quit? ";
	}

	@Override
	public boolean runSeaquence() {
		printMessage("TODAY : "+RegisterSetting.getTodayString());
		printMessage(this.promptMessage());
		String input = readString();
		if ( input.length() == 0  ) return false;
		RegisterSetting.setToday(input);
		return true;
	}

}
