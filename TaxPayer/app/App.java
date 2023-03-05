package TaxPayer.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import TaxPayer.entities.Company;
import TaxPayer.entities.Individual;
import TaxPayer.entities.TaxPayer;

public class App {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    final List<TaxPayer> taxPayers = new ArrayList<>();

    System.out.print("Enter the number of tax payers: ");
    final int payersAmount = scanner.nextInt();

    for (int i = 0; i < payersAmount; i++) {
      System.out.println();
      System.out.println("Tax payer #" + (i + 1) + " data:");

      System.out.print("Individual or company (i/c)? ");
      final char payerType = scanner.next().charAt(0);

      scanner.nextLine();

      System.out.print("Name: ");
      final String payerName = scanner.nextLine();

      System.out.print("Anual income: ");
      final double payerAnualIncome = scanner.nextDouble();

      if (payerType == 'i') {
        System.out.print("Health expenditures: ");
        final double healthExpenditures = scanner.nextDouble();

        taxPayers.add(new Individual(payerName, payerAnualIncome, healthExpenditures));

        continue;
      }

      if (payerType == 'c') {
        System.out.print("Number of employees: ");
        final int numberOfEmployees = scanner.nextInt();

        taxPayers.add(new Company(payerName, payerAnualIncome, numberOfEmployees));

        continue;
      }
    }

    System.out.println();
    System.out.println("TAXES PAID:");

    double taxAmount = 0;

    for (TaxPayer taxPayer : taxPayers) {
      final double taxPaid = taxPayer.taxPaid();

      taxAmount += taxPaid;

      System.out.printf("%s: $ %.2f \n", taxPayer.getName(), taxPaid);
    }

    System.out.println();
    System.out.printf("TOTAL TAXES: $ %.2f \n", taxAmount);

    scanner.close();
  }
}
