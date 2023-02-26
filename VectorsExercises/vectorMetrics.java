package VectorsExercises;

import java.util.Locale;
import java.util.Scanner;

public class vectorMetrics {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the amount of numbers to be entered:");
    int amount = scanner.nextInt();

    double[] doubleVector = new double[amount];
    double sum = 0;
    double average;

    for (int i = 0; i < doubleVector.length; i++) {
      System.out.print("Type a number: ");

      double value = scanner.nextDouble();

      doubleVector[i] = value;

      sum += value;
    }

    average = sum / doubleVector.length;

    System.out.print("VALUES: ");

    for (double value : doubleVector) {
      System.out.printf("%.1f ", value);
    }

    System.out.println();

    System.out.println("SUM: " + sum);
    System.out.println("AVERAGE: " + average);

    scanner.close();
  }
}
