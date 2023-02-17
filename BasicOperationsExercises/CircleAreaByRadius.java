package BasicOperationsExercises;

import java.util.Locale;
import java.util.Scanner;

public class CircleAreaByRadius {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the circle radius:");

    double circleRadius = scanner.nextDouble();

    double result = Math.PI * Math.pow(circleRadius, 2);

    System.out.printf("CALC = %.4f * %.2f ** 2 \n", Math.PI, circleRadius);

    System.out.printf("AREA = %.4f \n", result);

    scanner.close();
  }

}
