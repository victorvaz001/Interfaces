package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	
	private Double pricePerDay;
	private Double pricePerHour;
	
	BrazilTaxService taxService;
	
	public RentalService(Double pricePerHour, Double pricePerDay,  BrazilTaxService taxService) {
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		
		/*Encontrar diferança entre dois instantes*/
		double minutes = Duration.between(carRental.getStart(), carRental.getFisish()).toMinutes();
		double hours = minutes / 60.0;
		
		double basicPayment;
		if (hours <= 12.0) {
			basicPayment = pricePerHour * Math.ceil(hours); /*arredonda para cima*/
		}
		else {
			basicPayment = pricePerDay * Math.ceil(hours / 24.0); /*calculo por dia*/
		}
		
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}
