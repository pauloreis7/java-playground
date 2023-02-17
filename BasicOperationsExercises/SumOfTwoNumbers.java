package BasicOperationsExercises;

import java.util.Locale;
import java.util.Scanner;

public class SumOfTwoNumbers {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the first number:");

    int firstNumber = scanner.nextInt();

    System.out.println("Type the second number:");

    int seconNumber = scanner.nextInt();

    int result = firstNumber + seconNumber;

    System.out.printf("CALC = %d + %d \n", firstNumber, seconNumber);

    System.out.println("SUM = " + result);

    scanner.close();
  }
}
