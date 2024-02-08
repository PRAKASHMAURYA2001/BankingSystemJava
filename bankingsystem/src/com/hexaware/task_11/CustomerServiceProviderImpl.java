package com.hexaware.task_11;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceProviderImpl implements ICustomerServiceProvider{
	
	// This could be a database or data store where account information is stored
    private List<Account> accounts = new ArrayList<>();

    @Override
    public double getAccountBalance(long accountNumber) {
        // Implement logic to retrieve account balance from the data store
        // and return the current balance
        // Example: Find the account in the 'accounts' list and return its balance
        Account account = findAccountByNumber(accountNumber);
        return account != null ? account.getAccountBalance() : -1; // Return -1 if account not found
    }

    @Override
    public double deposit(long accountNumber, float amount) {
        // Implement logic to deposit the specified amount into the account
        // Example: Find the account in the 'accounts' list and update its balance
        Account account = findAccountByNumber(accountNumber);
        if (account != null) {
            account.setAccountBalance(account.getAccountBalance() + amount);
            return account.getAccountBalance();
        }
        return -1; // Return -1 if account not found
    }

    @Override
    public double withdraw(long accountNumber, float amount) {
        // Implement logic to withdraw the specified amount from the account
        // Example: Find the account in the 'accounts' list and update its balance
        Account account = findAccountByNumber(accountNumber);
        if (account != null) {
            // Check for minimum balance in case of a savings account
            if (account instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount) account;
                if (savingsAccount.getAccountBalance() - amount < 500) {
                    System.out.println("Withdrawal violates minimum balance rule.");
                    return account.getAccountBalance();
                }
            }
            
            account.setAccountBalance(account.getAccountBalance() - amount);
            return account.getAccountBalance();
        }
        return -1; // Return -1 if account not found
    }

    @Override
    public void transfer(long fromAccountNumber, long toAccountNumber, float amount) {
        // Implement logic to transfer money from one account to another
        // Example: Find the 'from' and 'to' accounts in the 'accounts' list and update their balances
        Account fromAccount = findAccountByNumber(fromAccountNumber);
        Account toAccount = findAccountByNumber(toAccountNumber);

        if (fromAccount != null && toAccount != null) {
            // Check for minimum balance in case of a savings account
            if (fromAccount instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount) fromAccount;
                if (savingsAccount.getAccountBalance() - amount < 500) {
                    System.out.println("Transfer violates minimum balance rule.");
                    return;
                }
            }

            // Perform the transfer
            fromAccount.setAccountBalance(fromAccount.getAccountBalance() - amount);
            toAccount.setAccountBalance(toAccount.getAccountBalance() + amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Invalid account numbers for transfer.");
        }
    }

    @Override
    public Account getAccountDetails(long accountNumber) {
        // Implement logic to retrieve both account and customer details
        // Example: Find the account in the 'accounts' list and return it
        return findAccountByNumber(accountNumber);
    }

    private Account findAccountByNumber(long accountNumber) {
        // Helper method to find an account by its account number
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

}
