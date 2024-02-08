package com.hexaware.task_8;

import com.hexaware.task_7.Account;

public class SavingsAccount extends Account {
	 private double interestRate;

	 // Parameter constructor
	 public SavingsAccount(int accountNumber, String accountType, double accountBalance, double interestRate) {
	     super(accountNumber, accountType, accountBalance);
	     this.interestRate = interestRate;
	 }

	 // Override calculate_interest() method to calculate interest based on balance and interest rate
	 @Override
	 public void calculateInterest() {
	     double interest = accountBalance * (interestRate / 100);
	     accountBalance += interest;
	     System.out.println("Interest of $" + interest + " added. Updated balance: $" + accountBalance);
	 }
	}
