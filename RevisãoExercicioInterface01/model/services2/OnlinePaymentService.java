package model.services2;

public interface OnlinePaymentService {
	
	double paymentFee(double ammount);
	double interest(double ammount, int months);
}
