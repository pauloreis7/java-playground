package BasicOperationsExercises;

import java.util.Locale;
import java.util.Scanner;

public class CalculatePartsAmount {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the first part code, number of parts and the unit value ($) of each piece:");

    scanner.nextInt();
    int numberOfFirstParts = scanner.nextInt();
    double firstPartUnitValue = scanner.nextDouble();

    System.out.println("Type the second part code, number of parts and the unit value ($) of each piece:");

    scanner.nextInt();
    int numberOfSecondParts = scanner.nextInt();
    double secondPartUnitValue = scanner.nextDouble();

    double result = numberOfFirstParts * firstPartUnitValue + numberOfSecondParts * secondPartUnitValue;

    System.out.printf("CALC = %d * %.2f + %d * %.2f \n", numberOfFirstParts, firstPartUnitValue, numberOfSecondParts,
        secondPartUnitValue);

    System.out.printf("AMOUNT TO PAY = U$ %.2f \n", result);

    scanner.close();
  }

}
