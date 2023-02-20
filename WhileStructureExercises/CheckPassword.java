package WhileStructureExercises;

import java.util.Locale;
import java.util.Scanner;

public class CheckPassword {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type your password");

    int password = scanner.nextInt();
    final int correctPassword = 2002;

    while (password != correctPassword) {
      System.out.println("Invalid password");

      System.out.println("Type your password");

      password = scanner.nextInt();
    }

    System.out.println("Permitted access");

    scanner.close();
  }
}
