package ConditionalStructureExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class Product {
  private int code;
  private double amount;

  public Product(final int code, final double amount) {
    this.code = code;
    this.amount = amount;
  }

  public int getCode() {
    return code;
  }

  public double getAmount() {
    return amount;
  }
}

public class CalculateAccountValue {

  private static List<Product> products = productsList();

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the product code:");

    int productCode = scanner.nextInt();

    System.out.println("Type the product quantity:");

    int productQuantity = scanner.nextInt();

    double total = 0;

    for (Product item : products) {
      if (item.getCode() == productCode) {
        total = productQuantity * item.getAmount();

        System.out.printf("TOTAL: $ %.2f \n", total);

        scanner.close();

        break;
      }
    }
  }

  private static List<Product> productsList() {
    Product tomato = new Product(1, 4);
    Product apple = new Product(2, 4.5);
    Product bread = new Product(3, 5);
    Product potato = new Product(4, 2);
    Product banana = new Product(5, 1.5);

    List<Product> products = Arrays.asList(tomato, apple, bread, potato, banana);

    return products;
  }
}
