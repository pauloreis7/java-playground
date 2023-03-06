package AccountExceptionHandling.entities;

import AccountExceptionHandling.exceptions.DomainException;

public class Account {
  private final int code;
  private final String holder;
  private double balance;
  private final double withdrawLimit;

  public Account(final int code, final String holder, final double balance, final double withdrawLimit) {
    this.code = code;
    this.holder = holder;
    this.balance = balance;
    this.withdrawLimit = withdrawLimit;
  }

  public double getBalance() {
    return balance;
  }

  public int getCode() {
    return code;
  }

  public String getHolder() {
    return holder;
  }

  public double getWithdrawLimit() {
    return withdrawLimit;
  }

  public void deposit(final double amount) {
    balance += amount;
  }

  public void withdraw(final double amount) {
    if (amount > balance) {
      throw new DomainException("Not enough balance");
    }

    if (amount > withdrawLimit) {
      throw new DomainException("The amount exceeds withdraw limit");
    }

    balance -= amount;
  }
}
