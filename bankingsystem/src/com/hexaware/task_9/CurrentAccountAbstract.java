package com.hexaware.task_9;

//import com.hexaware.model.BankAccountAbstract;

//task 9.2

public class CurrentAccountAbstract extends BankAccountAbstract {
	private double overdraftLimit;
  private static final double OVERDRAFT_LIMIT = -1000.0;

  // Parameterized constructor
  public CurrentAccountAbstract(int accountNumber, String customerName, double balance, double overdraftLimit) {
      super(accountNumber, customerName, balance);
      this.overdraftLimit = overdraftLimit;
  }

  @Override
  public void deposit(float amount) {
      setBalance(getBalance() + amount);
      System.out.println("Deposit of $" + amount + " successful. Updated balance: $" + getBalance());
  }

  @Override
  public void withdraw(float amount) {
      if (amount <= getBalance()) {
          setBalance(getBalance() - amount);
          System.out.println("Withdrawal of $" + amount + " successful. Updated balance: $" + getBalance());
      } else if (amount <= (getBalance() - overdraftLimit)) {
          setBalance(getBalance() - amount);
          System.out.println("Withdrawal of $" + amount + " successful (with overdraft). Updated balance: $" + getBalance());
      } else {
          System.out.println("Withdrawal limit exceeded. Withdrawal failed.");
      }
  }

  @Override
  public void calculateInterest() {
      // Current account has no interest, so this method is not implemented
      System.out.println("Current accounts do not earn interest.");
  }
}
