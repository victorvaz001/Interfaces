package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities2.Contract;
import model.entities2.Installment;
import model.services2.ContractService;
import model.services2.PaypalService;

public class Program3 {

	public static void main(String[] args) {
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate contractDate = LocalDate.parse(sc.next(), format);
		System.out.print("Valor do contrato: ");
		double valueContract = sc.nextDouble();
		
		Contract contract = new Contract(number, contractDate, valueContract);
		
		ContractService contractService = new ContractService(new PaypalService());
		
		System.out.print("Entre com o numero de parcelas: ");
		int numberOfInstallment = sc.nextInt();
		
		contractService.processContract(contract, numberOfInstallment);
		
		
		
		System.out.println();
		System.out.println("Parcelas: ");
		for (Installment inst : contract.getInstallments()) {
			System.out.println(format.format(inst.getDueDate()) + " - " + inst.getAmmount());
		}
		sc.close();

	}

}
