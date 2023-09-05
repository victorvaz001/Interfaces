package model.services;

public class PaypalService implements OnlinePaymentService {

	@Override
	public double interest(double ammount, int month) {			
		return ammount * month / 100.00;
	}
	
	@Override
	public double paymenetFee(double ammount) {		
		return ammount * 0.02;
	}

}
