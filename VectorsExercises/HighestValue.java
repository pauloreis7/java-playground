package VectorsExercises;

import java.util.Locale;
import java.util.Scanner;

public class HighestValue {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the amount of numbers to be entered:");
    int amount = scanner.nextInt();

    double[] intVector = new double[amount];
    double highestValue = 0;
    int highestValueIndex = 0;

    for (int i = 0; i < intVector.length; i++) {
      System.out.print("Type a number: ");

      double value = scanner.nextDouble();

      intVector[i] = value;

      if (value > highestValue) {
        highestValue = value;
        highestValueIndex = i;
      }
    }

    System.out.printf("HIGHEST VALUE: %.1f \n", highestValue);
    System.out.println("HIGHEST VALUE INDEX: " + highestValueIndex);

    scanner.close();
  }
}
