package WorkersContractsSalary.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import WorkersContractsSalary.entities.Department;
import WorkersContractsSalary.entities.HourContract;
import WorkersContractsSalary.entities.Worker;
import WorkersContractsSalary.entities.enums.WorkerLevel;

public class App {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    System.out.print("Enter department's name: ");
    final String departmentName = scanner.nextLine();

    final Department department = new Department(departmentName);

    System.out.println();
    System.out.println("Enter worker data: ");
    System.out.println();

    System.out.print("Name: ");
    final String workerName = scanner.nextLine();

    System.out.print("Level: ");
    final String workerLevel = scanner.nextLine();
    final WorkerLevel workerLevelEnum = WorkerLevel.valueOf(workerLevel);

    System.out.print("Base salary: ");
    final Double baseSalary = scanner.nextDouble();

    Worker worker = new Worker(workerName, workerLevelEnum, baseSalary, department);

    System.out.println();
    System.out.print("How many contracts to this worker? ");
    final Integer contractsAmount = scanner.nextInt();

    for (int i = 0; i < contractsAmount; i++) {
      System.out.println();
      System.out.println("Enter contract #" + (i + 1) + " data:");

      System.out.print("Date (DD/MM/YYYY): ");
      final String contractDateInput = scanner.next();

      LocalDate contractDate = LocalDate.parse(contractDateInput, dateFmt);

      System.out.print("Value per hour: ");
      final Double contractValuePerHour = scanner.nextDouble();

      System.out.print("Duration (hours): ");
      final Integer contractDuration = scanner.nextInt();

      HourContract hourContract = new HourContract(contractDate, contractValuePerHour, contractDuration);

      worker.addContract(hourContract);
    }

    scanner.nextLine();

    System.out.println();
    System.out.print("Enter month and year to calculate income (MM/YYYY): ");
    final String incomeDateInput = scanner.nextLine();
    System.out.println();

    LocalDate incomeDate = LocalDate.parse("01/" + incomeDateInput, dateFmt);

    Double income = worker.income(incomeDate.getYear(), incomeDate.getMonthValue());

    Double totalIncome = income + worker.getBaseSalary();

    System.out.println("Name: " + worker.getName());
    System.out.println("Department: " + worker.getDepartment().getName());
    System.out.printf("Income for %s: %.2f \n", incomeDateInput, totalIncome);

    scanner.close();
  }
}
