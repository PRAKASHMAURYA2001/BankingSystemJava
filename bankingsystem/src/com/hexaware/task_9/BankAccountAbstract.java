package com.hexaware.task_9;

//task 9.1


//Abstract class BankAccount
public abstract class BankAccountAbstract {
protected int accountNumber;
protected String customerName;
protected double balance;

//Default constructor
public BankAccountAbstract() {
 this.accountNumber = 0;
 this.customerName = "Default Customer";
 this.balance = 0.0;
}

//Parameterized constructor
public BankAccountAbstract(int accountNumber, String customerName, double balance) {
 this.accountNumber = accountNumber;
 this.customerName = customerName;
 this.balance = balance;
}

//Getter and setter methods
public int getAccountNumber() {
 return accountNumber;
}

public void setAccountNumber(int accountNumber) {
 this.accountNumber = accountNumber;
}

public String getCustomerName() {
 return customerName;
}

public void setCustomerName(String customerName) {
 this.customerName = customerName;
}

public double getBalance() {
 return balance;
}

public void setBalance(double balance) {
 this.balance = balance;
}

//Abstract methods
public abstract void deposit(float amount);

public abstract void withdraw(float amount);

public abstract void calculateInterest();

//Method to display account information
public void displayAccountInfo() {
 System.out.println("Account Number: " + accountNumber);
 System.out.println("Customer Name: " + customerName);
 System.out.println("Balance: $" + balance);
}
}
