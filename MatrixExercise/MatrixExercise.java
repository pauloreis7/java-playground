package MatrixExercise;

import java.util.Locale;
import java.util.Scanner;

public class MatrixExercise {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the amount of rows in the matrix:");
    int rowsAmount = scanner.nextInt();

    System.out.println("Type the amount of cols in the matrix:");
    int colsAmount = scanner.nextInt();

    int[][] matrix = new int[rowsAmount][colsAmount];

    for (int i = 0; i < matrix.length; i++) {
      System.out.print("Type " + colsAmount + " col numbers " + "(line " + (i + 1) + "): ");

      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }

    System.out.println();

    System.out.println("Type the number to find in the matrix:");
    int numberToFind = scanner.nextInt();

    System.out.println();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        int currentNumber = matrix[i][j];

        if (currentNumber != numberToFind) {
          continue;
        }

        System.out.println();

        System.out.println("Position: " + i + "," + j);

        if (j != 0) {
          System.out.println("Left: " + (matrix[i][j - 1]));
        }

        if (j != (matrix[i].length - 1)) {
          System.out.println("Right: " + (matrix[i][j + 1]));
        }

        if (i != 0) {
          System.out.println("Up: " + (matrix[i - 1][j]));
        }

        if (i != (matrix.length - 1)) {
          System.out.println("Down: " + (matrix[i + 1][j]));
        }
      }
    }

    scanner.close();
  }
}
