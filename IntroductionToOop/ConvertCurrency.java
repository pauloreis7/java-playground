package IntroductionToOop;

import java.util.Locale;
import java.util.Scanner;

class CurrencyConverter {

  public static double convert(final double price, final double amount) {
    return amount * price;
  }
}

public class ConvertCurrency {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the dollar price:");
    final double price = scanner.nextDouble();

    System.out.println("How many dollars will be bought:");
    final double amount = scanner.nextDouble();

    final double valueToPay = CurrencyConverter.convert(price, amount);

    System.out.printf("Amount to be paid: %.2f \n", valueToPay);

    scanner.close();
  }
}
