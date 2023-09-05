package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program2 {

	public static void main(String[] args) {
		
		//Marcara de formatação
	   DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados do contrato: ");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate contractDate = LocalDate.parse(sc.next(), format);
		System.out.print("Valor do contrato: ");
		double contractValue = sc.nextDouble();
		
		Contract contract = new Contract(number, contractDate, contractValue);
		       
     // Instanciando um contractService passando um onlinepatmentService, que no caso e o Paypall, ingeção de dependencia pelo consturtor
        ContractService contractService = new ContractService(new PaypalService());
               
        System.out.print("Entre com o numero de parcelas: ");
        int numberOfInstallments = sc.nextInt();

        contractService.processContract(contract, numberOfInstallments);

        // Mostra parcelas
        System.out.println("Parcelas: ");
        //List<Installment> installments = contract.getInstallments();
        
        for (Installment installment : contract.getInstallments()) {
       
            System.out.println(format.format(installment.getDueDate()) + " - " +  installment.getAmmount());
        }
        sc.close();
    }

}
