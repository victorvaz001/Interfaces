package model.services2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entities2.Contract;
import model.entities2.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	
	public void processContract(Contract contract, int months) {
		
		/*Achando o valor da parcela original*/
		double valueInstalmmentOrigin = contract.getTotalValue() / months;
		
		//Pegando a lista original
		List<Installment> listOrigen = contract.getInstallments();
		
		//Data de partida do Contrato
		LocalDate deuDate = contract.getDate();
		
		//Gerando nova lista para armazenar os valores atualizdos comas taxas
		List<Installment> newList = new ArrayList<>();
		
		for (int i = 1; i <= months; i++) {
						
			//Aumentar 30 dias apartartir da data original
			deuDate = deuDate.plusMonths(1);
			
			//Adicionado juros na parcela
			double valueInstallment = valueInstalmmentOrigin + onlinePaymentService.interest(valueInstalmmentOrigin, i);
			valueInstallment += onlinePaymentService.paymentFee(valueInstallment);
			
			//Instancia uma nova parcela ja com o juros e taxa
			Installment installment = new Installment(deuDate, valueInstallment);
			
			newList.add(installment);
		}
		listOrigen.addAll(newList);				
	}
	
}
