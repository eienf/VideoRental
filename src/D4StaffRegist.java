
public class D4StaffRegist extends Menu {

	@Override
	public void finalize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public String openingMessage() {
		return "*** Create new Staff ***";
	}

	@Override
	public String promptMessage() {
		return "input new Staff Name ? ";
	}

	@Override
	public boolean runSeaquence() {
		printMessage("Registered Staff number : "+ObjectStore.getInstance().numberOfStaff());
		printMessage(this.promptMessage());
		String input = readString();
		if ( input.length() == 0  ) return false;
		Staff staff = new Staff(input);
		ObjectStore.getInstance().saveStaff(staff);
		printMessage("(Created)"+staff);
		return true;
	}

}
