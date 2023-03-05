package TaxPayer.entities;

public class Company extends TaxPayer {

  private final int numberOfEmployees;

  public Company(final String name, final double anualIncome, final int numberOfEmployees) {
    super(name, anualIncome);

    this.numberOfEmployees = numberOfEmployees;
  }

  public int getNumberOfEmployees() {
    return numberOfEmployees;
  }

  @Override
  public double taxPaid() {
    double taxPercent = 0.16;

    if (this.numberOfEmployees > 10) {
      taxPercent = 0.14;
    }

    final double total = super.getAnualIncome() * taxPercent;

    return total;
  }
}
