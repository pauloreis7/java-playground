import java.util.Locale;
import java.util.Scanner;

public class DivideValuesRange {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the amount divisions to calculate:");
    int amount = scanner.nextInt();

    for (int i = 0; i < amount; i++) {
      System.out.println("Type division numerator:");
      int numerator = scanner.nextInt();

      System.out.println("Type division denominator:");
      int denominator = scanner.nextInt();

      if (denominator == 0) {
        System.out.println("Impossible division");
        continue;
      }

      double result = (double) numerator / denominator;

      System.out.printf("RESULT: %.1f \n", result);
    }

    scanner.close();
  }
}
