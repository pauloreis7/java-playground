package BasicOperationsExercises;

import java.util.Locale;
import java.util.Scanner;

public class CalculateDifference {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the first number (A):");

    int numberA = scanner.nextInt();

    System.out.println("Type the second number (B):");

    int numberB = scanner.nextInt();

    System.out.println("Type the third number (C):");

    int numberC = scanner.nextInt();

    System.out.println("Type the fourth number (D):");

    int numberD = scanner.nextInt();

    int result = numberA * numberB - numberC * numberD;

    System.out.printf("CALC = %d * %d - %d * %d \n", numberA, numberB, numberC, numberD);

    System.out.println("RESULT = " + result);

    scanner.close();
  }
}
