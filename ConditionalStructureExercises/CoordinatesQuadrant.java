package ConditionalStructureExercises;

import java.util.Locale;
import java.util.Scanner;

public class CoordinatesQuadrant {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the X coordinate:");

    double coordinateX = scanner.nextDouble();

    System.out.println("Type the Y coordinate:");

    double coordinateY = scanner.nextDouble();
    scanner.close();

    if (coordinateX == 0.0 && coordinateY == 0.0) {
      System.out.println("Origin");
      return;
    }

    if (coordinateX == 0.0) {
      System.out.println("X Axis");
      return;
    }

    if (coordinateY == 0.0) {
      System.out.println("Y Axis");
      return;
    }

    if (coordinateX > 0 && coordinateY > 0) {
      System.out.println("Quadrant 1");
    } else if (coordinateX > 0 && coordinateY < 0) {
      System.out.println("Quadrant 4");
    } else if (coordinateX < 0 && coordinateY < 0) {
      System.out.println("Quadrant 3");
    } else {
      System.out.println("Quadrant 2");
    }
  }
}