package com.hexaware.task_8;

import java.util.Scanner;

import com.hexaware.task_7.Account;
//import com.hexaware.model.CurrentAccount;
//import com.hexaware.model.SavingsAccount;

//task 8
public class BankInheritance {
	public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);

   // Display menu for user to create object for account class
   System.out.println("Choose account type:");
   System.out.println("1. Savings Account");
   System.out.println("2. Current Account");
   System.out.print("Enter your choice (1 or 2): ");
   int accountTypeChoice = scanner.nextInt();

   switch (accountTypeChoice) {
       case 1:
           // Create Savings Account
           System.out.print("Enter account number: ");
           int savingsAccountNumber = scanner.nextInt();

           System.out.print("Enter initial balance: $");
           double savingsInitialBalance = scanner.nextDouble();

           System.out.print("Enter interest rate: ");
           double interestRate = scanner.nextDouble();

           SavingsAccount savingsAccount = new SavingsAccount(savingsAccountNumber, null, savingsInitialBalance, interestRate);

           // Perform operations on Savings Account
           performOperations(savingsAccount);
           break;

       case 2:
           // Create Current Account
           System.out.print("Enter account number: ");
           int currentAccountNumber = scanner.nextInt();

           System.out.print("Enter initial balance: $");
           double currentInitialBalance = scanner.nextDouble();

           System.out.print("Enter overdraft limit: $");
           double overdraftLimit = scanner.nextDouble();

           CurrentAccount currentAccount = new CurrentAccount(currentAccountNumber, null, currentInitialBalance, overdraftLimit);

           // Perform operations on Current Account
           performOperations(currentAccount);
           break;

       default:
           System.out.println("Invalid choice. Exiting program.");
   }

   // Close the scanner
   scanner.close();
}

// Helper method to perform operations on an account
private static void performOperations(Account account) {
   Scanner scanner = new Scanner(System.in);

   boolean continueTransactions = true;

   while (continueTransactions) {
       // Display menu options
       System.out.println("\nOptions:");
       System.out.println("1. Deposit");
       System.out.println("2. Withdraw");
       System.out.println("3. Check Balance");
       System.out.println("4. Exit");

       // Prompt the user to choose an option
       System.out.print("Enter your choice (1-4): ");
       int choice = scanner.nextInt();

       switch (choice) {
           case 1:
               // Deposit
               System.out.print("Enter the deposit amount: $");
               double depositAmount = scanner.nextDouble();
               account.deposit(depositAmount);
               break;

           case 2:
               // Withdraw
               System.out.print("Enter the withdrawal amount: $");
               double withdrawalAmount = scanner.nextDouble();
               account.withdraw(withdrawalAmount);
               break;

           case 3:
               // Check Balance
               System.out.println("Current Balance: $" + account.getAccountBalance());
               break;

           case 4:
               // Exit
               continueTransactions = false;
               break;

           default:
               System.out.println("Invalid choice. Please enter a number between 1 and 4.");
       }
   }

   // Close the scanner
   scanner.close();
}
}
