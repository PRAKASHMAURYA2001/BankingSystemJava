package com.hexaware.task_10;

public class Account {
    private long accountNumber;
    private String accountType;
    private double accountBalance;
    private Customer customer;

    // Default constructor
    public Account() {
    }

    // Overloaded constructor with auto-generated account number
    public Account(long accountNumber, String accountType, double accountBalance, Customer customer) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.customer = customer;
    }
    
 

    // Getter and setter methods for attributes
    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

/*    // Method to generate a unique account number
    private static long generateAccountNumber() {
    	Bank bk = new Bank();
        return bk.nextAccountNumber++;
    }*/
    
    // Method to print all information of the account
    public void printAccountInfo() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: $" + accountBalance);
        System.out.println("Customer Information:");
        customer.printCustomerInfo();
    }
}
