package com.hexaware.task_8;



public class Account {
	 
	 protected int accountNumber;
	 protected String accountType;
	 protected double accountBalance;
	 
	 
	 private static int accountNumberGenerator = 1000;
	 
	    // Default constructor
	    public Account() {
	    }

	    // Parameterized constructor
	    public Account(int accountNumber, String accountType, double accountBalance) {
	        this.accountNumber =  generateAccountNumber();
	        this.accountType = accountType;
	        this.accountBalance = accountBalance;
	        
	    }
	    private int generateAccountNumber() {
	        return accountNumberGenerator++;
	    }


	    // Getter and Setter methods for all attributes
	    public int getAccountNumber() {
	        return accountNumber;
	    }

	    public void setAccountNumber(int accountNumber) {
	        this.accountNumber = accountNumber;
	    }

	    public String getAccountType() {
	        return accountType;
	    }

	    public void setAccountType(String accountType) {
	        this.accountType = accountType;
	    }

	    public double getAccountBalance() {
	        return accountBalance;
	    }

	    public void setAccountBalance(double accountBalance) {
	        this.accountBalance = accountBalance;
	    }
	    
	   

	    // Method to deposit money into the account
	    public void deposit(double amount) {
	        accountBalance += amount;
	        System.out.println("Deposit of $" + amount + " successful. Updated balance: $" + accountBalance);
	    }

	    // Method to withdraw money from the account
	    public void withdraw(double amount) {
	        if (amount <= accountBalance) {
	            accountBalance -= amount;
	            System.out.println("Withdrawal of $" + amount + " successful. Updated balance: $" + accountBalance);
	        } else {
	            System.out.println("Insufficient balance. Withdrawal failed.");
	        }
	    }

	    // Method to calculate and add interest to the account balance
	    public void calculateInterest() {
	        if (accountType.equalsIgnoreCase("Savings")) {
	            double interest = accountBalance * 0.045; // 4.5% interest rate
	            accountBalance += interest;
	            System.out.println("Interest of $" + interest + " added. Updated balance: $" + accountBalance);
	        }
	    }

	    // Method to print all account information
	    public void printAccountInfo() {
	        System.out.println("Account Number: " + accountNumber);
	        System.out.println("Account Type: " + accountType);
	        System.out.println("Account Balance: $" + accountBalance);
	        System.out.println("Customer Information:");
	        
	    }
//task 8.1------------------------------------------------------------------------------------------------
	    // Overloaded deposit methods
	    public void deposit(float amount) {
	    	accountBalance += amount;
	        System.out.println("Deposit of $" + amount + " successful. Updated balance: $" + accountBalance);
	    }

	    public void deposit(int amount) {
	    	accountBalance += amount;
	        System.out.println("Deposit of $" + amount + " successful. Updated balance: $" + accountBalance);
	    }
	    
	    // Overloaded withdraw methods
	    public void withdraw(float amount) {
	        if (amount <= accountBalance) {
	        	accountBalance -= amount;
	            System.out.println("Withdrawal of $" + amount + " successful. Updated balance: $" + accountBalance);
	        } else {
	            System.out.println("Insufficient balance. Withdrawal failed.");
	        }
	    }

	    public void withdraw(int amount) {
	        if (amount <= accountBalance) {
	        	accountBalance -= amount;
	            System.out.println("Withdrawal of $" + amount + " successful. Updated balance: $" + accountBalance);
	        } else {
	            System.out.println("Insufficient balance. Withdrawal failed.");
	        }
	    }
}
