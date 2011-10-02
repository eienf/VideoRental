
public class D3MemberRegist extends Menu {

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
		return "*** Create new Member ***";
	}

	@Override
	public String promptMessage() {
		return "input new Member Name ? ";
	}

	@Override
	public boolean runSeaquence() {
		printMessage("Registered Member number : "+ObjectStore.getInstance().numberOfMember());
		printMessage(this.promptMessage());
		String input = readString();
		if ( input.length() == 0  ) return false;
		Member object = new Member(input);
		ObjectStore.getInstance().saveMember(object);
		printMessage("(Created)"+object);
		return true;
	}

}
