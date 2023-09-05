package model.entities2;

import java.time.LocalDate;

public class Installment {
	
	private LocalDate dueDate;
	private Double ammount;
	
	public Installment() {
	}

	public Installment(LocalDate dueDate, Double ammount) {
		this.dueDate = dueDate;
		this.ammount = ammount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmmount() {
		return ammount;
	}

	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}
	
	
}
