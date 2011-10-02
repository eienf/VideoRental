
public class D1Rental extends Menu {

	@Override
	public void finalize() {
		printMessage("QUIT VIDEO RENTAL.");
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public String openingMessage() {
		return "*** Video Rental ***";
	}

	@Override
	public String promptMessage() {
		return "hit RETURN to quit.";
	}

	@Override
	public boolean runSeaquence() {
		String input;
		Staff staff;
		Member member;
		ObjectStore os = ObjectStore.getInstance();
		printMessage(this.promptMessage());
		while ( true ) {
			printMessage("Please Input Member ID : ");
			input = readString();
			if ( input.equalsIgnoreCase("Cancel") ) return false;
			member = os.getMember(input);
			if ( member != null ) {
				printMessage("Member : "+member.getName());
				break;
			}
		}
		if ( member.beInRental()) {
			printMessage("You are in Rental");
			return false;
		}
		while ( true ) {
			printMessage("Please Input Staff ID : ");
			input = readString();
			if ( input.equalsIgnoreCase("Cancel") ) return false;
			staff = os.getStaff(input);
			if ( staff != null ) {
				printMessage("Staff : "+staff.getName());
				break;
			}
		}
		Rental rental = new Rental();
		rental.setStaff(staff);
		rental.setMember(member);
		while ( true ) {
			printMessage("Please Input Goods ID(or END) : ");
			input = readString();
			if ( input.equalsIgnoreCase("Cancel") ) return false;
			if ( input.equalsIgnoreCase("END") ) break;
			if ( rental.addVideoEntity(input) ) {
				printMessage("*** Did add video.");
			} else {
				printMessage("--- Fail to add video.");
			}
			if ( rental.numberOfDetail() >= 5 ) break;
		}
		InputTerm:
		while ( true ) {
			printMessage("Please Input Term (2...2Nights / 7...7nights / C...cancel) : ");
			int number = readInt();
			if ( number == 0 ) return false;
			switch ( number ) {
			case 2:
				rental.setRentalPeriod(RentalPeriod.n2d3);
				break InputTerm;
			case 7:
				rental.setRentalPeriod(RentalPeriod.n7d8);
				break InputTerm;
			}
		}
		rental.calcRentalCharge();
		while ( true ) {
			printMessage("Print Total Charge : "+rental.getRentalCharge());
			printMessage("Pay(Y) : ");
			input = readString();
			if ( input.equalsIgnoreCase("Cancel") ) return false;
			if ( input.substring(0, 1).equalsIgnoreCase("Y") ) break;
		}
		rental.didFixRental();
		ObjectStore.getInstance().saveRental(rental);
		printMessage("Print Receipt : ");
		printMessage(rental.getReceipt());
		printMessage("(hit return key)");
		input = readString();
		printMessage("Thank you");
		return false;
	}

}
