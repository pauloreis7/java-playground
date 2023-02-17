package BasicOperationsExercises;

import java.util.Locale;
import java.util.Scanner;

public class GeometricShapesArea {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the A number:");

    double numberA = scanner.nextDouble();

    System.out.println("Type the B number:");

    double numberB = scanner.nextDouble();

    System.out.println("Type the C number:");

    double numberC = scanner.nextDouble();

    double rightTriangleArea = numberA * numberC / 2;
    double circleArea = Math.PI * Math.pow(numberC, 2);
    double trapezeArea = (numberA + numberB) / 2 * numberC;
    double squareArea = numberB * numberB;
    double rectangleArea = numberA * numberB;

    System.out.printf("CALC RIGHT TRIANGLE AREA = %.3f * %.3f / 2 \n", numberA, numberC);
    System.out.printf("CALC CIRCLE AREA = %.4f * %.3f ** 2 \n", Math.PI, numberC);
    System.out.printf("CALC TRAPEZE AREA = (%.3f + %.3f) / 2 * %.3f \n", numberA, numberB, numberC);
    System.out.printf("CALC SQUARE AREA = %.3f * %.3f \n", numberB, numberB);
    System.out.printf("CALC RECTANGLE AREA = %.3f * %.3f \n", numberA, numberB);

    System.out.printf("RIGHT TRIANGLE AREA = %.3f \n", rightTriangleArea);
    System.out.printf("CIRCLE AREA = %.3f \n", circleArea);
    System.out.printf("TRAPEZE AREA = %.3f \n", trapezeArea);
    System.out.printf("SQUARE AREA = %.3f \n", squareArea);
    System.out.printf("RECTANGLE AREA = %.3f \n", rectangleArea);

    scanner.close();
  }

}
