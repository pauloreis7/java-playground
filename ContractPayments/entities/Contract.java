package ContractPayments.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

  private final int code;
  private final LocalDate date;
  private final double totalValue;

  private final List<Installment> installments = new ArrayList<Installment>();

  public Contract(final int code, final LocalDate date, final double totalValue) {
    this.code = code;
    this.date = date;
    this.totalValue = totalValue;
  }

  public int getCode() {
    return code;
  }

  public LocalDate getDate() {
    return date;
  }

  public double getTotalValue() {
    return totalValue;
  }

  public List<Installment> getInstallments() {
    return installments;
  }

  public void addInstallment(final Installment installment) {
    installments.add(installment);
  }
}
