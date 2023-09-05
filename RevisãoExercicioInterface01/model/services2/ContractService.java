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
		double basicQuota = contract.getTotalValue() / months;
				
		//Pegando a lista original
		List<Installment> listOrigen = contract.getInstallments();
						
		for (int i = 1; i <= months; i++) {
						
			//Aumentar 30 dias apartir da data original
			LocalDate deuDate = contract.getDate().plusMonths(i);
			
			//Adicionado juros na parcela
			double interest = onlinePaymentService.interest(basicQuota, i);
			double fee =  onlinePaymentService.paymentFee(basicQuota + interest);
			
			double quota = basicQuota + interest + fee;
			
			//Instancia uma nova parcela ja com o juros e taxa
			contract.getInstallments().add(new Installment(deuDate, quota));
						
		}
					
	}
	
}
