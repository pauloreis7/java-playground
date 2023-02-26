package VectorsExercises;

import java.util.Locale;
import java.util.Scanner;

public class EvenNumbers {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the amount of numbers to be entered:");
    int amount = scanner.nextInt();

    int evenNumbersAmount = 0;
    int[] intVector = new int[amount];

    for (int i = 0; i < intVector.length; i++) {
      System.out.println("Type a number: ");

      intVector[i] = scanner.nextInt();
    }

    System.out.println("EVEN NUMBERS:");

    for (int value : intVector) {
      if (value % 2 != 0) {
        continue;
      }

      evenNumbersAmount++;

      System.out.print(value + " ");
    }

    System.out.println();

    System.out.println("NUMBER OF EVENS: " + evenNumbersAmount);

    scanner.close();
  }
}
