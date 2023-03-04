package ClientOrders.entities;

public class OrderItem {
  private final int quantity;
  private final double price;
  private final Product product;

  public OrderItem(final int quantity, final double price, final Product product) {
    this.quantity = quantity;
    this.price = price;
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getPrice() {
    return price;
  }

  public double subTotal() {
    return quantity * price;
  }

  @Override
  public String toString() {
    return String.format("%s, $%.2f, Quantity: %d, Subtotal: $%.2f", product.getName(), product.getPrice(), quantity,
        subTotal());
  }
}
