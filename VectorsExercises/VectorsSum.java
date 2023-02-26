package VectorsExercises;

import java.util.Locale;
import java.util.Scanner;

public class VectorsSum {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the amount of numbers to be entered in each vector:");
    int amount = scanner.nextInt();

    int[] intVectorA = new int[amount];
    int[] intVectorB = new int[amount];
    int[] intVectorC = new int[amount];

    System.out.println();
    System.out.println("Type the vector A values: ");

    for (int i = 0; i < intVectorA.length; i++) {
      System.out.print("Type a number: ");

      intVectorA[i] = scanner.nextInt();
    }

    System.out.println();
    System.out.println("Type the vector B values: ");

    for (int i = 0; i < intVectorB.length; i++) {
      System.out.print("Type a number: ");

      intVectorB[i] = scanner.nextInt();

      intVectorC[i] = intVectorB[i] + intVectorA[i];
    }

    System.out.println();
    System.out.println("VECTOR SUM (A + B): ");

    for (int value : intVectorC) {
      System.out.println(value);
    }

    scanner.close();
  }

}
