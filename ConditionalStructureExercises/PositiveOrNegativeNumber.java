package ConditionalStructureExercises;

import java.util.Locale;
import java.util.Scanner;

public class PositiveOrNegativeNumber {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the int number:");

    int intNumber = scanner.nextInt();

    scanner.close();

    if (intNumber < 0) {
      System.out.println("NEGATIVE");
      return;
    }

    System.out.println("POSITIVE");
  }

}