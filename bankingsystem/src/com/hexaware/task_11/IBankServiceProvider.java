package com.hexaware.task_11;

public interface IBankServiceProvider {
    // Create a new bank account for the given customer with the initial balance
    void createAccount(Customer customer, long accNo, String accType, float balance);

    // List all accounts in the bank
    Account[] listAccounts();

    // Calculate interest based on the balance and interest rate
    void calculateInterest();
    
    Account findAccountByNumber(long accountNumber);

    double withdraw(long accountNumber,float amount);

    double deposit(long accountNumber,float amount);

    Account getAccountDetails(long accountNumber);

    double getAccountBalance(long accountNumber);
}

