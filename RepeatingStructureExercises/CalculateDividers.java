import java.util.Locale;
import java.util.Scanner;

public class CalculateDividers {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the number to get dividers:");
    int value = scanner.nextInt();

    for (int i = 1; i <= value; i++) {
      int divisionRest = value % i;

      if (divisionRest == 0) {
        System.out.println(i);
      }
    }

    scanner.close();
  }
}
