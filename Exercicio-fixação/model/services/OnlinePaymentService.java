package model.services;

public interface OnlinePaymentService {
	
	double paymenetFee(double ammount); /*taxa de pagamento*/
	double interest(double ammount, int month); /*juros*/
}
