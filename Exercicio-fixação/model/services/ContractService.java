package model.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;
		
	 public ContractService(OnlinePaymentService onlinePaymentService) {		
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int numberOfInstallments) {

		// Encontre o valor das parcelas a serem pagas
	    double valueInstallment = contract.getTotalValue() / numberOfInstallments;

	    // Pega a lista de parcelas do contrato
	    List<Installment> installments = contract.getInstallments();

	    // Data de partida do contrato
	    LocalDate currentDueDate = contract.getDate();

	    // Lista para armazenar as novas parcelas
	    List<Installment> newInstallments = new ArrayList<>();

	    for (int i = 1; i <= numberOfInstallments; i++) {
	        // Adiciona um mês à data de vencimento atual
	        currentDueDate = currentDueDate.plusMonths(1);

	        // Gera a nova parcela com juros e taxa incluídos
	        double installmentAmount = valueInstallment + onlinePaymentService.interest(valueInstallment, i);
	        installmentAmount += onlinePaymentService.paymenetFee(installmentAmount);
	        
	        //Instanciando a parcela atualizada
	        Installment newInstallment = new Installment(currentDueDate, installmentAmount);

	        // Adiciona a nova parcela à lista de novas parcelas
	        newInstallments.add(newInstallment);
	    }

	    // Adiciona as novas parcelas à lista original
	    installments.addAll(newInstallments);
	}
}

