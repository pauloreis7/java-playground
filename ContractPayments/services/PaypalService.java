package ContractPayments.services;

public class PaypalService implements IOnlinePaymentService {

  public double paymentFee(final double amount) {
    return amount * 0.02;
  }

  public double interest(final double amount, final int months) {
    return amount * (0.01 * months);
  }
}
