package ContractPayments.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
  private static final DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private final LocalDate dueDate;
  private final double amount;

  public Installment(final LocalDate dueDate, final double amount) {
    this.dueDate = dueDate;
    this.amount = amount;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public double getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    String formattedDate = dateFmt.format(getDueDate());

    return formattedDate + " - " + String.format("%.2f", getAmount());
  }
}
