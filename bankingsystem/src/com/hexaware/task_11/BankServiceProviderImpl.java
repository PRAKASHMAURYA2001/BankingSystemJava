package com.hexaware.task_11;

import java.util.ArrayList;
import java.util.List;

public class BankServiceProviderImpl extends CustomerServiceProviderImpl implements IBankServiceProvider{
	
    // This could be a data store or database where account information is stored
    private List<Account> accounts = new ArrayList<>();

    @Override
    public void createAccount(Customer customer, long accNo, String accType, float balance) {
        // Implement logic to create a new bank account
        // Example: Create a new account object and add it to the 'accounts' list
        Account newAccount;

        if ("Savings".equalsIgnoreCase(accType)) {
            newAccount = new SavingsAccount(0.02, customer); // Example interest rate for savings account
        } else if ("Current".equalsIgnoreCase(accType)) {
            newAccount = new CurrentAccount(1000, customer); // Example overdraft limit for current account
        } else {
            newAccount = new ZeroBalanceAccount(customer);
        }

        newAccount.setAccountBalance(balance);
        accounts.add(newAccount);
    }

    @Override
    public Account[] listAccounts() {
        // Implement logic to list all accounts
        // Example: Convert the 'accounts' list to an array and return
        return accounts.toArray(new Account[0]);
    }

    @Override
    public void calculateInterest() {
        // Implement logic to calculate interest for all applicable accounts
        // Example: Iterate through the 'accounts' list and calculate interest for savings accounts
        for (Account account : accounts) {
            if (account instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount) account;
                double interest = savingsAccount.getAccountBalance() * savingsAccount.getInterestRate();
                System.out.println("Interest for account " + account.getAccountNumber() + ": " + interest);
            }
        }
    }

    @Override
    public Account findAccountByNumber(long accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
    
    @Override
    public double deposit(long accountNumber, float amount) {
        // Find the account by its account number
        Account account = findAccountByNumber(accountNumber);

        // If account is found
        if (account != null) {
            // Update the account balance after deposit
            account.setAccountBalance(account.getAccountBalance() + amount);
            System.out.println("Deposit successful. New balance: " + account.getAccountBalance());
            return account.getAccountBalance();
        } else {
            System.out.println("Account not found.");
        }

        return -1; // Return -1 if the deposit was not successful
    }
    
    @Override
    public double withdraw(long accountNumber, float amount) {
        // Find the account by its account number
        Account account = findAccountByNumber(accountNumber);

        // If account is found
        if (account != null) {
            // Check for minimum balance in case of a savings account
            if (account instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount) account;
                if (savingsAccount.getAccountBalance() - amount < 500) {
                    System.out.println("Withdrawal violates minimum balance rule.");
                    return account.getAccountBalance();
                }
            }

            // Check if the account has sufficient balance
            if (account.getAccountBalance() >= amount) {
                // Update the account balance after withdrawal
                account.setAccountBalance(account.getAccountBalance() - amount);
                System.out.println("Withdrawal successful. New balance: " + account.getAccountBalance());
                return account.getAccountBalance();
            } else {
                System.out.println("Insufficient funds for withdrawal.");
            }
        } else {
            System.out.println("Account not found.");
        }
        
        @Override
        Account getAccountDetails(long accountNumber1) {
            // Find the account by its account number
            Account account1 = findAccountByNumber(accountNumber);

            // If account is found
            if (account != null) {
                return account;
            } else {
                System.out.println("Account not found.");
                return null; // Return null if the account is not found
            }
        }
        
        @Override
        public double getAccountBalance(long accountNumber) {
            // Find the account by its account number
            Account account = findAccountByNumber(accountNumber);

            // If account is found
            if (account != null) {
                return account.getAccountBalance();
            } else {
                System.out.println("Account not found.");
                return -1; // Return -1 if the account is not found
            }
        }
        
        return -1; // Return -1 if the withdrawal was not successful
    }

}

