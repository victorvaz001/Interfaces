package model.entities2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
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

	@Override
	public String toString() {
		return dueDate.format(fmt) + " - " + String.format("%.2f", ammount);
	}
	
	
}
