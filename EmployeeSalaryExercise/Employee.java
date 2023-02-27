package EmployeeSalaryExercise;

class Employee {

  private final int id;
  private final String name;
  private double salary;

  public Employee(final int id, final String name, final double salary) {
    this.id = id;
    this.name = name;
    this.salary = salary;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getSalary() {
    return salary;
  }

  public void increaseSalary(final double percentage) {
    salary += (salary * percentage) / 100.00;
  }

  @Override
  public String toString() {
    return String.format("%d, %s, %.2f", id, name, salary);
  }
}
