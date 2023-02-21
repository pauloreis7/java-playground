import java.util.Locale;
import java.util.Scanner;

public class ValuesInOrOutOfRange {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    final int minRange = 10;
    final int maxRange = 20;

    System.out.println("Type the amount to input:");
    int amount = scanner.nextInt();

    int inRangeCount = 0;
    int outOfRangeCount = 0;

    for (int i = 0; i < amount; i++) {
      int currentNumber = scanner.nextInt();

      if (currentNumber >= minRange && currentNumber <= maxRange) {
        inRangeCount++;

        continue;
      }

      outOfRangeCount++;
    }

    System.out.println("IN RANGE = " + inRangeCount);
    System.out.println("OUT OF RANGE = " + outOfRangeCount);

    scanner.close();
  }
}
