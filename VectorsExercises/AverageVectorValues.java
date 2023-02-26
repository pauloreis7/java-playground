package VectorsExercises;

import java.util.Locale;
import java.util.Scanner;

public class AverageVectorValues {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the amount of numbers to be entered:");
    int amount = scanner.nextInt();

    double valuesSum = 0;
    double[] doubleVector = new double[amount];

    for (int i = 0; i < doubleVector.length; i++) {
      System.out.print("Type a number: ");

      double value = scanner.nextDouble();

      doubleVector[i] = value;

      valuesSum += value;
    }

    double average = valuesSum / doubleVector.length;

    System.out.println();
    System.out.printf("VECTOR AVERAGE: %.3f \n", average);

    System.out.println();
    System.out.println("BELOW AVERAGE VALUES:");

    for (double value : doubleVector) {
      if (value >= average) {
        continue;
      }

      System.out.println(value);
    }

    scanner.close();
  }
}
