package com.hexaware.task_9;

//import com.hexaware.model.BankAccountAbstract;

//task 9.2

public class SavingsAccountAbstract extends BankAccountAbstract {
	private double interestRate;

  // Parameterized constructor
  public SavingsAccountAbstract(int accountNumber, String customerName, double balance, double interestRate) {
      super(accountNumber, customerName, balance);
      this.interestRate = interestRate;
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
      } else {
          System.out.println("Insufficient balance. Withdrawal failed.");
      }
  }

  @Override
  public void calculateInterest() {
      double interest = getBalance() * (interestRate / 100);
      setBalance(getBalance() + interest);
      System.out.println("Interest of $" + interest + " added. Updated balance: $" + getBalance());
  }
}