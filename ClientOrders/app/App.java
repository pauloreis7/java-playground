package ClientOrders.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import ClientOrders.entities.Client;
import ClientOrders.entities.Order;
import ClientOrders.entities.OrderItem;
import ClientOrders.entities.Product;
import ClientOrders.enums.OrderStatus;

public class App {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    System.out.println("Enter client data:");
    System.out.println();

    System.out.print("Name: ");
    final String clientName = scanner.nextLine();

    System.out.print("Email: ");
    final String clientEmail = scanner.nextLine();

    System.out.print("Birth date (DD/MM/YYYY): ");
    final String clientBirthDateInput = scanner.nextLine();

    LocalDate clientBirthDate = LocalDate.parse(clientBirthDateInput, dateFmt);

    final Client client = new Client(clientName, clientEmail, clientBirthDate);

    System.out.println();
    System.out.println("Enter order data:");
    System.out.println();

    System.out.print("Status: ");
    final String orderStatus = scanner.nextLine();

    final Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(orderStatus), client);

    System.out.println();
    System.out.print("How many items to this order? ");
    final int itemsAmount = scanner.nextInt();

    for (int i = 0; i < itemsAmount; i++) {
      System.out.println();
      System.out.println("Enter " + "#" + (i + 1) + " item data:");
      System.out.println();

      scanner.nextLine();

      System.out.print("Product name: ");
      final String productName = scanner.nextLine();

      System.out.print("Product price: ");
      final double productPrice = scanner.nextDouble();

      System.out.print("Quantity: ");
      final int quantity = scanner.nextInt();

      final Product product = new Product(productName, productPrice);

      OrderItem ordemItem = new OrderItem(quantity, productPrice, product);

      order.addItem(ordemItem);
    }

    System.out.println();

    System.out.println("ORDER SUMMARY:");
    System.out.println(order);

    scanner.close();
  }
}
