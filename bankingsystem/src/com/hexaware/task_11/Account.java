package com.hexaware.task_11;

public class Account {
	private static int lastAccNo = 1001; // static variable for generating account number

	private int accountNumber;
	private String accountType;
	private double accountBalance;
	private Customer accountOwner;

	// Default constructor
	public Account() {
		this.accountNumber = generateAccountNumber();
	}

	// Overloaded constructor with all attributes
	public Account(String accountType, double accountBalance, Customer accountOwner) {
		this.accountNumber = generateAccountNumber();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.accountOwner = accountOwner;
	}

	// Getter methods
	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public Customer getAccountOwner() {
		return accountOwner;
	}

	// Setter methods
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void setAccountOwner(Customer accountOwner) {
		this.accountOwner = accountOwner;
	}

	// Generate unique account number using static variable
	private static int generateAccountNumber() {
		return ++lastAccNo;
	}
}

//SavingsAccount class
class SavingsAccount extends Account {
	private double interestRate;

	// Default constructor for SavingsAccount
	public SavingsAccount() {
		super("Savings", 500, null); // minimum balance for savings account is 500
		this.interestRate = 0.02; // default interest rate
	}

	// Overloaded constructor for SavingsAccount
	public SavingsAccount(double interestRate, Customer accountOwner) {
		super("Savings", 500, accountOwner); // minimum balance for savings account is 500
		this.interestRate = interestRate;
	}

	// Getter method for interest rate
	public double getInterestRate() {
		return interestRate;
	}
}

//CurrentAccount class
class CurrentAccount extends Account {
	private double overdraftLimit;

	// Default constructor for CurrentAccount
	public CurrentAccount() {
		super("Current", 0, null); // current account can be created with zero balance
		this.overdraftLimit = 1000; // default overdraft limit
	}

	// Overloaded constructor for CurrentAccount
	public CurrentAccount(double overdraftLimit, Customer accountOwner) {
		super("Current", 0, accountOwner); // current account can be created with zero balance
		this.overdraftLimit = overdraftLimit;
	}

	// Getter method for overdraft limit
	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	// Withdraw method to allow overdraft up to a certain limit
	public void withdraw(double amount) {
		double availableBalance = getAccountBalance() + overdraftLimit;
		if (amount <= availableBalance) {
			setAccountBalance(getAccountBalance() - amount);
		} else {
			System.out.println("Insufficient funds! Withdrawal not allowed beyond overdraft limit.");
		}
	}
}

//ZeroBalanceAccount class
class ZeroBalanceAccount extends Account {
	// Default constructor for ZeroBalanceAccount
	public ZeroBalanceAccount(Customer accountOwner) {
		super("Zero Balance", 0, accountOwner); // zero balance for zero balance account
	}
}

