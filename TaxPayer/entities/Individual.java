package TaxPayer.entities;

public class Individual extends TaxPayer {

  private final double healthExpenditures;

  public Individual(final String name, final double anualIncome, final double healthExpenditures) {
    super(name, anualIncome);

    this.healthExpenditures = healthExpenditures;
  }

  public double getHealthExpenditures() {
    return healthExpenditures;
  }

  @Override
  public double taxPaid() {
    double taxPercent = 0.15;

    if (super.getAnualIncome() >= 20000.00) {
      taxPercent = 0.25;
    }

    final double total = (super.getAnualIncome() * taxPercent) - (this.healthExpenditures * 0.5);

    return total;
  }
}
