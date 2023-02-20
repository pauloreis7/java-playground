package WhileStructureExercises;

import java.util.Locale;
import java.util.Scanner;

public class CoordinatesQuadrant {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the X coordinate:");

    int coordinateX = scanner.nextInt();

    System.out.println("Type the Y coordinate:");

    int coordinateY = scanner.nextInt();

    while (coordinateX != 0 && coordinateY != 0) {
      if (coordinateX > 0 && coordinateY > 0) {
        System.out.println("first");
      } else if (coordinateX > 0 && coordinateY < 0) {
        System.out.println("fourth");
      } else if (coordinateX < 0 && coordinateY < 0) {
        System.out.println("third");
      } else {
        System.out.println("second");
      }

      System.out.println("Type the X coordinate:");
      coordinateX = scanner.nextInt();

      System.out.println("Type the Y coordinate:");
      coordinateY = scanner.nextInt();
    }

    scanner.close();
  }
}
