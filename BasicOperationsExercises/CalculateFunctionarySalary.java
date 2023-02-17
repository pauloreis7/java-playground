package BasicOperationsExercises;

import java.util.Locale;
import java.util.Scanner;

public class CalculateFunctionarySalary {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the functionary number:");

    int functinaryNumber = scanner.nextInt();

    System.out.println("Type the functionary hours worked amount:");

    int hoursWorked = scanner.nextInt();

    System.out.println("Type the functionary salary per hours amount:");

    double salaryPerHour = scanner.nextDouble();

    double salaryAmount = hoursWorked * salaryPerHour;

    System.out.printf("CALC = %d * %.2f \n", hoursWorked, salaryPerHour);

    System.out.println("FUNCTIONARY NUMBER = " + functinaryNumber);

    System.out.printf("SALARY = U$ %.2f \n", salaryAmount);

    scanner.close();
  }
}
