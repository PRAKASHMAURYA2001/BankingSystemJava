package com.hexaware.task_10;

//task 10

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankTask10 bankAcc = new BankTask10();

        while (true) {
            System.out.print("\nEnter a command \n1. Create Account \n2. Deposit \n3. Withdraw \n4. Transfer \n5. Get Account Details \n6. Exit \n=> ");
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    // Gather customer details
                    System.out.println("\nEnter customer details:");
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Email Address: ");
                    String emailAddress = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Address: ");
                    String address = scanner.nextLine();

                    // Create customer object
                    Customer customer = new Customer(0, firstName, lastName, emailAddress, phoneNumber, address);

                    // Display account type sub-menu
                    System.out.println("Choose account type (Savings, Current):");
                    String accountType = scanner.nextLine();

                    // Create account
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    bankAcc.createAccount(customer, accountType, initialBalance);

                    System.out.println("Account created successfully.");
                    break;

                case "2":
                    System.out.print("Enter account number: ");
                    long depositAccountNumber = scanner.nextLong();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    double depositResult = bankAcc.deposit(depositAccountNumber, depositAmount);
                    if (depositResult != -1) {
                        System.out.println("Deposit successful. Current balance: $" + depositResult);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case "3":
                    System.out.print("Enter account number: ");
                    long withdrawAccountNumber = scanner.nextLong();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    double withdrawResult = bankAcc.withdraw(withdrawAccountNumber, withdrawAmount);
                    if (withdrawResult != -1) {
                        System.out.println("Withdrawal successful. Current balance: $" + withdrawResult);
                    } else {
                        System.out.println("Account not found or insufficient funds.");
                    }
                    break;

                case "4":
                    System.out.print("Enter from account number: ");
                    long fromAccountNumber = scanner.nextLong();
                    System.out.print("Enter to account number: ");
                    long toAccountNumber = scanner.nextLong();
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    bankAcc.transfer(fromAccountNumber, toAccountNumber, transferAmount);
                    break;

                case "5":
                    System.out.print("Enter account number: ");
                    long accountDetailsNumber = scanner.nextLong();
                    bankAcc.getAccountDetails(accountDetailsNumber);
                    break;

                case "6":
                    System.out.println("Exiting BankApp. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid command. Please try again.");
            }

            // Consume the newline character
            scanner.nextLine();
        }
    }
}
