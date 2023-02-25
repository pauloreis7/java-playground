package BankingOperationsExercise;

public class Account {
  private final int code;
  private String holderName;
  private double balance;

  private final static double BANK_FEE = 5.00;

  public Account(final int code, final String holderName, final double initialDepositValue) {
    this.code = code;
    this.holderName = holderName;

    deposit(initialDepositValue);
  }

  public Account(final int code, final String holderName) {
    this.code = code;
    this.holderName = holderName;
  }

  public int getCode() {
    return code;
  }

  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(final String holderName) {
    this.holderName = holderName;
  }

  public double getBalance() {
    return balance;
  }

  public void deposit(final double amount) {
    balance += amount;
  }

  public void withdrawal(final double amount) {
    balance -= (amount + BANK_FEE);
  }

  @Override
  public String toString() {
    return String.format("Account %d, Holder: %s, Balance: $ %.2f", code, holderName, balance);
  }
}
