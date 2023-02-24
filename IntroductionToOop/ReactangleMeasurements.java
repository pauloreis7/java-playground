package IntroductionToOop;

import java.util.Locale;
import java.util.Scanner;

class Reactangle {
  private double width;

  private double height;

  public Reactangle(final double width, final double height) {
    this.width = width;
    this.height = height;
  }

  public double area() {
    return width * height;
  }

  public double perimeter() {
    return (width + height) * 2;
  }

  public double diagonal() {
    return Math.sqrt(width * width + height * height);
  }
}

public class ReactangleMeasurements {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the rectangle width:");
    double width = scanner.nextDouble();

    System.out.println("Enter the rectangle height:");
    double height = scanner.nextDouble();

    Reactangle reactangle = new Reactangle(width, height);

    System.out.printf("AREA = %.2f \n", reactangle.area());
    System.out.printf("PERIMETER = %.2f \n", reactangle.perimeter());
    System.out.printf("DIAGONAL = %.2f \n", reactangle.diagonal());

    scanner.close();
  }
}
