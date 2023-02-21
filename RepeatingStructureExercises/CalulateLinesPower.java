import java.util.Locale;
import java.util.Scanner;

public class CalulateLinesPower {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the lines amount to calculate the power:");
    int amount = scanner.nextInt();

    for (int i = 1; i <= amount; i++) {
      int powerToOne = i;
      int powerToTwo = i * i;
      int powerToThree = powerToTwo * i;

      System.out.printf("POWER: %d %d %d \n", powerToOne, powerToTwo, powerToThree);
    }

    scanner.close();
  }
}
