
public class D2Return extends Menu {

	@Override
	public void finalize() {
		printMessage("QUIT VIDEO RETURN.");
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public String openingMessage() {
		return "*** Video Return ***";
	}

	@Override
	public String promptMessage() {
		return "input receipt number or RETURN to quit?";
	}

	@Override
	public boolean runSeaquence() {
		String input;
		Rental rental = null;
		while ( rental == null ) {
			printMessage(this.promptMessage());
			input = readString();
			if ( input.length() == 0  ) return false;
			rental = ObjectStore.getInstance().getRental(input);
		}
		printMessage("Print Receipt : ");
		printMessage(rental.getReceipt());
		rental.calcExtraCharge();
		int extraCharge = rental.getExtraCharge();
		if ( extraCharge > 0 ) {
			printMessage("Scheduled Return : "+RegisterSetting.date2string(rental.getScheduledReturn()));
			printMessage("Today : "+RegisterSetting.getTodayString());
			printMessage("Print Extra Charge : "+extraCharge);
			printString("Pay this (Y/N) ");
			input = readString();
			if ( !input.startsWith("Y") ) {
				printMessage("Not Returned");
				return false;
			}
		} else {
			printMessage("No need Extra Charge");
		}
		printMessage("Accept Return.(hit return key)");
		input = readString();
		rental.didFixReturn();
		printMessage("Thank you");
		return false;
	}

}
