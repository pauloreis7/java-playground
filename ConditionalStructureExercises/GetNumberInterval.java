package ConditionalStructureExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GetNumberInterval {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    final List<int[]> intervals = intervalsList();

    System.out.println("Type the number to find in interval:");

    double value = scanner.nextDouble();
    scanner.close();

    int[] valueInterval = null;

    for (int[] interval : intervals) {
      boolean isGreaterOrEqual = value >= interval[0];
      boolean isLessOrEqual = value <= interval[1];

      if (isGreaterOrEqual && isLessOrEqual) {
        valueInterval = interval;

        break;
      }
    }

    if (valueInterval == null) {
      System.out.println("OUT OF RANGE");
      return;
    }

    System.out.println("INTERVAL: " + Arrays.toString(valueInterval));
  }

  private static List<int[]> intervalsList() {
    final int[] interval01 = { 0, 25 };
    final int[] interval02 = { 25, 50 };
    final int[] interval03 = { 50, 75 };
    final int[] interval04 = { 75, 100 };

    List<int[]> intervals = Arrays.asList(interval01, interval02, interval03, interval04);

    return intervals;
  }
}
