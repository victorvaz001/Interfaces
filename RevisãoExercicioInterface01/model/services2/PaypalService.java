package model.services2;

public class PaypalService implements OnlinePaymentService {

	@Override
	public double paymentFee(double ammount) {
		
		return ammount * 0.02;
	}

	@Override
	public double interest(double ammount, int months) {	
		return ammount * 0.01 * months;
	}	
}
