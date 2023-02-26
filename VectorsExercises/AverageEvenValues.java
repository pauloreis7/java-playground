package VectorsExercises;

import java.util.Locale;
import java.util.Scanner;

public class AverageEvenValues {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the amount of numbers to be entered:");
    int amount = scanner.nextInt();

    double evenValuesSum = 0;
    double evenValuesCount = 0;
    int[] evenNumbersVector = new int[amount];

    for (int i = 0; i < evenNumbersVector.length; i++) {
      System.out.print("Type a number: ");

      int value = scanner.nextInt();

      evenNumbersVector[i] = value;

      if (value % 2 == 0) {
        evenValuesSum += value;
        evenValuesCount++;
      }
    }

    scanner.close();
    System.out.println();

    if (evenValuesCount == 0) {
      System.out.println("NO EVEN NUMBERS");
      return;
    }

    double evenValuesAverage = evenValuesSum / evenValuesCount;

    System.out.printf("EVEN VALUES AVERAGE: %.1f \n", evenValuesAverage);

  }
}
