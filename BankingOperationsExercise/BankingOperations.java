package BankingOperationsExercise;

import java.util.Locale;
import java.util.Scanner;

public class BankingOperations {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the account code:");
    final int code = scanner.nextInt();

    scanner.nextLine();

    System.out.println("Enter the account holder name:");
    final String holderName = scanner.nextLine();

    System.out.println("Is there an initial deposit value (y/n)?");
    final char initialDepositValueExists = scanner.nextLine().charAt(0);

    Account account;

    if (initialDepositValueExists == 'y') {
      System.out.println("Enter the account initial deposit value (optional):");
      final double initialDepositValue = scanner.nextDouble();

      account = new Account(code, holderName, initialDepositValue);
    } else {
      account = new Account(code, holderName);
    }

    System.out.println("Account data:");
    System.out.println(account);

    System.out.println("Enter a deposit value:");
    double depositValue = scanner.nextDouble();

    account.deposit(depositValue);

    System.out.println("Updated account data:");
    System.out.println(account);

    System.out.println("Enter a withdraw value:");
    double withdrawValue = scanner.nextDouble();

    account.withdrawal(withdrawValue);

    System.out.println("Updated account data:");
    System.out.println(account);

    scanner.close();
  }
}
