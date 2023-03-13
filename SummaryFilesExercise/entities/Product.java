package SummaryFilesExercise.entities;

public class Product {
  private final String name;
  private final double price;
  private final int quantity;

  public Product(final String name, final double price, final int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public double total() {
    return price * quantity;
  }
}
