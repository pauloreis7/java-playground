package ConditionalStructureExercises;

import java.util.Locale;
import java.util.Scanner;

public class MultipleNumbers {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the first int number:");

    int firstInt = scanner.nextInt();

    System.out.println("Type the second int number:");

    int secondInt = scanner.nextInt();
    scanner.close();

    int firstOrderDivisionRest = firstInt % secondInt;
    int secondOrderDivisionRest = secondInt % firstInt;

    if (firstOrderDivisionRest == 0 || secondOrderDivisionRest == 0) {
      System.out.println("ARE MULTIPLE");
      return;
    }

    System.out.println("ARE NOT MULTIPLES");

  }

}
