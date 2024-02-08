package com.hexaware.task_8;

import com.hexaware.task_7.Account;

public class CurrentAccount extends Account {
	 private double overdraftLimit;
	 private static final double OVERDRAFT_LIMIT = -1000.0; // Example overdraft limit

	 // Parameter constructor
	 public CurrentAccount(int accountNumber, String accountType, double balance, double overdraftLimit) {
	     super(accountNumber, accountType, balance);
	     this.overdraftLimit = overdraftLimit;
	 }

	 // Override withdraw() method to allow overdraft up to a certain limit
	 @Override
	 public void withdraw(double amount) {
	     if ((amount <= accountBalance) || (amount <= (accountBalance - overdraftLimit))) {
	    	 accountBalance -= amount;
	         System.out.println("Withdrawal of $" + amount + " successful. Updated balance: $" + accountBalance);
	     } else {
	         System.out.println("Withdrawal limit exceeded. Withdrawal failed.");
	     }
	 }
	}
