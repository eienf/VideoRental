
public class PriceCalc {
	public static int rentalPrice(MediaType media,RentalPeriod period){
		if( media == MediaType.DVD ) {
			if ( period == RentalPeriod.n2d3 ) return 100;
			if ( period == RentalPeriod.n7d8 ) return 200;
		} else if ( media == MediaType.BluRay ) {
			if ( period == RentalPeriod.n2d3 ) return 250;
			if ( period == RentalPeriod.n7d8 ) return 500;
		}
		return -1;
	}
	public static int extraCharge(){
		return 100;
	}
}
