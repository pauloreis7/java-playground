package ContractPayments.services;

import java.time.LocalDate;

import ContractPayments.entities.Contract;
import ContractPayments.entities.Installment;

public class ContractService {

  private final IOnlinePaymentService onlinePaymentService;

  public ContractService(final IOnlinePaymentService onlinePaymentService) {
    this.onlinePaymentService = onlinePaymentService;
  }

  public void processContract(final Contract contract, final int months) {
    final double intallmentAmount = contract.getTotalValue() / months;

    for (int i = 1; i <= months; i++) {
      final double interest = this.onlinePaymentService.interest(intallmentAmount, i);
      final double amountWithInterest = intallmentAmount + interest;

      final double paymentFee = this.onlinePaymentService.paymentFee(amountWithInterest);
      final double amountWithTax = amountWithInterest + paymentFee;

      final LocalDate installlmentDueDate = contract.getDate().plusMonths(i);

      final Installment installment = new Installment(installlmentDueDate, amountWithTax);

      contract.addInstallment(installment);
    }
  }
}
