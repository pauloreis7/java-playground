package VectorsExercises;

import java.util.Locale;
import java.util.Scanner;

public class NegativeNumbers {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the amount of numbers to be entered:");
    int amount = scanner.nextInt();

    int[] intVector = new int[amount];

    scanner.nextLine();

    for (int i = 0; i < intVector.length; i++) {
      System.out.print("Type a number: ");

      intVector[i] = scanner.nextInt();
    }

    System.out.println("NEGATIVE NUMBERS:");

    for (int value : intVector) {

      if (value >= 0) {
        continue;
      }

      System.out.println(value);
    }

    scanner.close();
  }
}
