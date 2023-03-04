package ClientOrders.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import ClientOrders.enums.OrderStatus;

public class Order {
  private static final DateTimeFormatter momentFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

  private final LocalDateTime moment;
  private final OrderStatus status;

  private final Client client;
  private List<OrderItem> items = new ArrayList<>();

  public Order(final LocalDateTime moment, final OrderStatus status, final Client client) {
    this.moment = moment;
    this.status = status;
    this.client = client;
  }

  public LocalDateTime getMoment() {
    return moment;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public Client getClient() {
    return client;
  }

  public void addItem(final OrderItem item) {
    items.add(item);
  }

  public void removeItem(final OrderItem item) {
    items.remove(item);
  }

  public double total() {
    double orderTotal = 0;

    for (OrderItem item : items) {
      orderTotal += item.subTotal();
    }

    return orderTotal;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("Order moment: ");
    stringBuilder.append(momentFmt.format(moment) + "\n");
    stringBuilder.append("Order status: ");
    stringBuilder.append(status + "\n");
    stringBuilder.append("Client: ");
    stringBuilder.append(client + "\n");
    stringBuilder.append("Order items: \n");

    for (OrderItem item : items) {
      stringBuilder.append(item + "\n");
    }

    stringBuilder.append("Total price: ");
    stringBuilder.append(total());

    return stringBuilder.toString();
  }
}
