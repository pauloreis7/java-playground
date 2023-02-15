interface ProductProps {
  String name = "";
  double value = 0.00;
}

class Product implements ProductProps {
  private String name;

  private double value;

  public Product(final String name, final double value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public double getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.format("%s, which price is $ %.2f", name, value);
  }

}