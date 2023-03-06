package AccountExceptionHandling.app;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import AccountExceptionHandling.entities.Account;
import AccountExceptionHandling.exceptions.DomainException;

public class App {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter account data");
    System.out.println();

    try {
      System.out.print("Code: ");
      final int accountCode = scanner.nextInt();

      scanner.nextLine();

      System.out.print("Holder: ");
      final String accountHolder = scanner.nextLine();

      System.out.print("Initial balance: ");
      final double initialBalance = scanner.nextDouble();

      System.out.print("Withdraw limit: ");
      final double accountWithdrawLimit = scanner.nextDouble();

      final Account account = new Account(accountCode, accountHolder, initialBalance, accountWithdrawLimit);

      System.out.println();

      System.out.print("Enter the amount for withdraw: ");
      final double withdrawAmount = scanner.nextDouble();

      System.out.println();

      account.withdraw(withdrawAmount);

      System.out.printf("New balance: %.2f \n", account.getBalance());
    } catch (InputMismatchException error) {
      System.out.println("Invalid data format.");
    } catch (DomainException error) {
      System.out.println("Withdraw error: " + error.getMessage());
    }

    scanner.close();
  }
}
