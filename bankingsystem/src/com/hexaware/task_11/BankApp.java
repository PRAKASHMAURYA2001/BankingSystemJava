package com.hexaware.task_11;

import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {
        IBankServiceProvider bankService = new BankServiceProviderImpl(); // Your BankService implementation
        ICustomerServiceProvider customerService = new CustomerServiceProviderImpl(); // Your CustomerService implementation
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Banking System Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Get Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Get Account Details");
            System.out.println("7. List Accounts");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createAccountMenu(bankService, customerService, scanner);
                    break;
                case 2:
                    performDeposit(bankService, scanner);
                    break;
                case 3:
                    performWithdraw(bankService, scanner);
                    break;
                case 4:
                    getBalance(bankService, scanner);
                    break;
                case 5:
                    performTransfer(bankService, scanner);
                    break;
                case 6:
                    getAccountDetails(bankService, scanner);
                    break;
                case 7:
                    listAccounts(bankService);
                    break;
                case 8:
                    exit = true;
                    System.out.println("Exiting the banking system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }

        scanner.close();
    }

    private static void createAccountMenu(IBankServiceProvider bankService,
                                          ICustomerServiceProvider customerService, Scanner scanner) {
        System.out.println("\n=== Create Account Menu ===");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.println("3. Zero Balance Account");
        System.out.println("4. Back to main menu");
        System.out.print("Enter your choice: ");

        int accountTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (accountTypeChoice >= 1 && accountTypeChoice <= 3) {
            // Prompt for customer details
            System.out.print("Enter customer first name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter customer last name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter customer email address: ");
            String emailAddress = scanner.nextLine();

            System.out.print("Enter customer phone number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Enter customer address: ");
            String address = scanner.nextLine();

            // Create a new customer
            Customer customer = new Customer(0, firstName, lastName, emailAddress, phoneNumber, address);

            // Generate a random account number
            long accountNumber = (long) (Math.random() * 100000 + 1000);

            // Prompt for initial balance
            System.out.print("Enter initial balance: ");
            float initialBalance = scanner.nextFloat();
            scanner.nextLine(); // Consume the newline character

            // Create the account based on the user's choice
            switch (accountTypeChoice) {
                case 1:
                    bankService.createAccount(customer, accountNumber, "Savings", initialBalance);
                    break;
                case 2:
                    bankService.createAccount(customer, accountNumber, "Current", initialBalance);
                    break;
                case 3:
                    bankService.createAccount(customer, accountNumber, "Zero Balance", initialBalance);
                    break;
            }

            System.out.println("Account created successfully!");
        } else if (accountTypeChoice == 4) {
            // Back to main menu
            System.out.println("Returning to the main menu.");
        } else {
            System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private static void performDeposit(IBankServiceProvider bankService, Scanner scanner) {
        System.out.print("Enter account number for deposit: ");
        long accountNumber = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter deposit amount: ");
        float amount = scanner.nextFloat();
        scanner.nextLine(); // Consume the newline character

        double newBalance = bankService.deposit(accountNumber, amount);

        if (newBalance >= 0) {
            System.out.println("Deposit successful. New balance: " + newBalance);
        } else {
            System.out.println("Failed to deposit. Account not found.");
        }
    }

    private static void performWithdraw(IBankServiceProvider bankService, Scanner scanner) {
        System.out.print("Enter account number for withdrawal: ");
        long accountNumber = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter withdrawal amount: ");
        float amount = scanner.nextFloat();
        scanner.nextLine(); // Consume the newline character

        double newBalance = bankService.withdraw(accountNumber, amount);

        if (newBalance >= 0) {
            System.out.println("Withdrawal successful. New balance: " + newBalance);
        } else {
            System.out.println("Failed to withdraw. Account not found or insufficient funds.");
        }
    }

    private static void getBalance(IBankServiceProvider bankService, Scanner scanner) {
        System.out.print("Enter account number to check balance: ");
        long accountNumber = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        double balance = bankService.getAccountBalance(accountNumber);

        if (balance >= 0) {
            System.out.println("Current balance: " + balance);
        } else {
            System.out.println("Failed to get balance. Account not found.");
        }
    }

    private static void performTransfer(IBankServiceProvider bankService, Scanner scanner) {
        System.out.print("Enter source account number for transfer: ");
        long fromAccountNumber = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter destination account number: ");
        long toAccountNumber = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter transfer amount: ");
        float amount = scanner.nextFloat();
        scanner.nextLine(); // Consume the newline character

        bankService.transfer(fromAccountNumber, toAccountNumber, amount);
    }

    private static void getAccountDetails(IBankServiceProvider bankService, Scanner scanner) {
        System.out.print("Enter account number to get details: ");
        long accountNumber = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        Account account = bankService.getAccountDetails(accountNumber);

        if (account != null) {
            System.out.println("Account Details:");
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Type: " + account.getAccountType());
            System.out.println("Account Balance: " + account.getAccountBalance());
            System.out.println("Customer Details:");
            System.out.println("Customer ID: " + account.getAccountOwner().getCustomerId());
            System.out.println("Customer Name: " + account.getAccountOwner().getFirstName()
                    + " " + account.getAccountOwner().getLastName());
            System.out.println("Customer Email: " + account.getAccountOwner().getEmailAddress());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void listAccounts(IBankServiceProvider bankService) {
        Account[] accounts = bankService.listAccounts();

        if (accounts.length > 0) {
            System.out.println("List of Accounts:");
            for (Account account : accounts) {
                System.out.println("Account Number: " + account.getAccountNumber());
                System.out.println("Account Type: " + account.getAccountType());
                System.out.println("Account Balance: " + account.getAccountBalance());
                System.out.println("Customer ID: " + account.getAccountOwner().getCustomerId());
                System.out.println("Customer Name: " + account.getAccountOwner().getFirstName()
                        + " " + account.getAccountOwner().getLastName());
                System.out.println("Customer Email: " + account.getAccountOwner().getEmailAddress());
                System.out.println("---------------------");
            }
        } else {
            System.out.println("No accounts available.");
        }
    }
}
