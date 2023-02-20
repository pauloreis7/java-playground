package WhileStructureExercises;

import java.util.Locale;
import java.util.Scanner;

public class GasStationClients {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    int alcohol = 0;
    int gasoline = 0;
    int diesel = 0;

    System.out.println("Type the product code:");

    int code = scanner.nextInt();

    while (code != 4) {
      switch (code) {
        case 1:
          alcohol += 1;
          break;
        case 2:
          gasoline += 1;
          break;
        case 3:
          diesel += 1;
      }

      System.out.println("Type the product code:");

      code = scanner.nextInt();
    }

    System.out.println("Completed purchase");

    System.out.println("Alcohol: " + alcohol);
    System.out.println("Gasoline: " + gasoline);
    System.out.println("Diesel: " + diesel);

    scanner.close();
  }
}
