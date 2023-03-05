package TaxPayer.entities;

public abstract class TaxPayer {

  private final String name;
  private final double anualIncome;

  public TaxPayer(final String name, final double anualIncome) {
    this.name = name;
    this.anualIncome = anualIncome;
  }

  public String getName() {
    return name;
  }

  public double getAnualIncome() {
    return anualIncome;
  }

  public abstract double taxPaid();
}
