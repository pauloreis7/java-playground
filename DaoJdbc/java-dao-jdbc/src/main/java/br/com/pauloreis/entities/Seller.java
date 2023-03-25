package br.com.pauloreis.entities;

import java.time.LocalDate;

public class Seller {

  private final int id;
  private String name;
  private final String email;
  private final LocalDate birthDate;
  private final double baseSalary;

  private final Department department;

  public Seller(
      final Integer id,
      final String name,
      final String email,
      final LocalDate birthDate,
      final double baseSalary,
      final Department department) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.birthDate = birthDate;
    this.baseSalary = baseSalary;
    this.department = department;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public double getBaseSalary() {
    return baseSalary;
  }

  public Department getDepartment() {
    return department;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Seller other = (Seller) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Seller " + id + " - " + name + "(" + email + ")" + " - " + baseSalary;
  }
}
