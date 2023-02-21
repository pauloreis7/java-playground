import java.util.Locale;
import java.util.Scanner;

public class CalculateFactorial {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the number to calculate factorial:");
    int value = scanner.nextInt();

    int factorial = 1;

    for (int i = 1; i <= value; i++) {
      factorial = factorial * i;
    }

    System.out.println("FACTORIAL: " + factorial);

    scanner.close();
  }
}
