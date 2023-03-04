package WorkersContractsSalary.entities;

import java.util.ArrayList;
import java.util.List;

import WorkersContractsSalary.entities.enums.WorkerLevel;

public class Worker {
  private final String name;
  private final WorkerLevel level;
  private final Double baseSalary;

  private final Department department;
  private List<HourContract> hourContracts = new ArrayList<>();

  public Worker(final String name, final WorkerLevel level, final Double baseSalary, final Department department) {
    this.name = name;
    this.level = level;
    this.baseSalary = baseSalary;
    this.department = department;
  }

  public String getName() {
    return name;
  }

  public WorkerLevel getlLevel() {
    return level;
  }

  public Double getBaseSalary() {
    return baseSalary;
  }

  public Department getDepartment() {
    return department;
  }

  public void addContract(final HourContract hourContract) {
    this.hourContracts.add(hourContract);
  }

  public void removeContract(final HourContract hourContract) {
    this.hourContracts.remove(hourContract);
  }

  public Double income(final Integer year, final Integer month) {
    Double salaryAmount = 0.0;

    for (HourContract hourContract : this.hourContracts) {
      boolean isYearEqual = hourContract.getDate().getYear() == year;
      boolean isMonthEqual = hourContract.getDate().getMonthValue() == month;

      if (isYearEqual && isMonthEqual) {
        salaryAmount += hourContract.totalValue();
      }
    }

    return salaryAmount;
  }
}
