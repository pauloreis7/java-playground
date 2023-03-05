package ProductsTags.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import ProductsTags.entities.ImportedProduct;
import ProductsTags.entities.Product;
import ProductsTags.entities.UsedProduct;

public class App {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    List<Product> products = new ArrayList<>();

    System.out.print("Enter the number of products: ");
    final int productsAmount = scanner.nextInt();

    for (int i = 0; i < productsAmount; i++) {
      System.out.println();

      System.out.println("Product #" + (i + 1) + " data:");

      System.out.print("Common, used or imported (c/u/i)? ");
      final char productType = scanner.next().charAt(0);

      scanner.nextLine();

      System.out.print("Name: ");
      final String productName = scanner.nextLine();

      System.out.print("Price: ");
      final double productPrice = scanner.nextDouble();

      if (productType == 'c') {
        products.add(new Product(productName, productPrice));
        continue;
      }

      if (productType == 'u') {
        scanner.nextLine();

        System.out.print("Manufacture date (DD/MM/YYYY): ");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        final LocalDate manufactureDate = LocalDate.parse(scanner.nextLine(), dateFormatter);

        products.add(new UsedProduct(productName, productPrice, manufactureDate));
        continue;
      }

      if (productType == 'i') {
        System.out.print("Customs fee: ");
        final double customFees = scanner.nextDouble();

        products.add(new ImportedProduct(productName, productPrice, customFees));
      }
    }

    System.out.println();
    System.out.println("PRICE TAGS:");

    for (Product product : products) {
      System.out.println(product.priceTag());
    }

    scanner.close();
  }
}
