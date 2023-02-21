import java.util.Locale;
import java.util.Scanner;

public class WeightedAverage {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the averages amount to calculate:");
    int amount = scanner.nextInt();

    for (int i = 0; i < amount; i++) {
      System.out.println("Type the values to average:");

      double valueA = scanner.nextDouble();
      double valueB = scanner.nextDouble();
      double valueC = scanner.nextDouble();

      double average = (valueA * 2 + valueB * 3 + valueC * 5) / 10;

      System.out.printf("Weighted average: %.1f \n", average);
    }

    scanner.close();
  }
}
