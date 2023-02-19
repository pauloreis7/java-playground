package ConditionalStructureExercises;

import java.util.Locale;
import java.util.Scanner;

public class CalculateIncomeTax {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type your salary:");

    double salary = scanner.nextDouble();
    scanner.close();

    double tax = 0;

    if (salary <= 2000) {
      System.out.println("Tax exempt");
      return;
    } else if (salary <= 3000) {
      tax = (salary - 2000) * 0.08;
    } else if (salary <= 4500) {
      tax = (salary - 3000) * 0.18 + 1000 * 0.08;
    } else {
      tax = (salary - 4500) * 0.28 + 1500 * 0.18 + 1000 * 0.08;
    }

    System.out.printf("$ %.2f \n", tax);

  }
}
