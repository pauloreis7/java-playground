package ProductsTags.entities;

public class ImportedProduct extends Product {
  private final double customFees;

  public ImportedProduct(final String name, final double price, final double customFees) {
    super(name, price);

    this.customFees = customFees;
  }

  public double getCustomFee() {
    return customFees;
  }

  public double totalPrice() {
    return super.getPrice() + customFees;
  }

  @Override
  public String priceTag() {
    return String.format("%s $ %.2f (Custom fee: $ %.2f)", getName(), totalPrice(), getCustomFee());
  }
}
