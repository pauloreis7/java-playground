import java.util.Locale;
import java.util.Scanner;

public class OddNumbersRange {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the number to odd range:");

    int maxValue = scanner.nextInt();

    for (int i = 0; i < maxValue; i++) {
      int divisionRest = i % 2;

      if (divisionRest != 0) {
        System.out.println(i);
      }
    }

    scanner.close();
  }
}
