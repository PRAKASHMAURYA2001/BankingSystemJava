package com.hexaware.task_11;

public interface ICustomerServiceProvider {
    // Retrieve the balance of an account given its account number
    double getAccountBalance(long accountNumber);

    // Deposit the specified amount into the account
    double deposit(long accountNumber, float amount);

    // Withdraw the specified amount from the account
    double withdraw(long accountNumber, float amount);

    // Transfer money from one account to another
    void transfer(long fromAccountNumber, long toAccountNumber, float amount);

    // Get account and customer details
    Account getAccountDetails(long accountNumber);
}
