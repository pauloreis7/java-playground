package ContractPayments.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import ContractPayments.entities.Contract;
import ContractPayments.entities.Installment;
import ContractPayments.services.ContractService;
import ContractPayments.services.IOnlinePaymentService;
import ContractPayments.services.PaypalService;

public class App {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);
    final DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    System.out.println("Type the contract data:");
    System.out.println();

    System.out.print("code: ");
    final int code = scanner.nextInt();

    scanner.nextLine();

    System.out.print("Date (dd/MM/yyyy): ");
    final String dateInput = scanner.nextLine();

    System.out.print("Contract amount value: ");
    final double totalValue = scanner.nextDouble();

    System.out.print("Type the installments amount: ");
    final int installmentsCount = scanner.nextInt();

    final LocalDate date = LocalDate.parse(dateInput, dateFmt);

    final Contract contract = new Contract(code, date, totalValue);

    final IOnlinePaymentService onlinePaymentService = new PaypalService();
    final ContractService contractService = new ContractService(onlinePaymentService);

    contractService.processContract(contract, installmentsCount);

    System.out.println("Installments:");
    System.out.println();

    for (Installment installment : contract.getInstallments()) {
      System.out.println(installment);
    }

    scanner.close();
  }
}
