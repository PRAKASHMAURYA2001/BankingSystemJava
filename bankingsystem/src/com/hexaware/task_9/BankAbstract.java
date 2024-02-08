package com.hexaware.task_9;

import java.util.Scanner;


//task 9.3
public class BankAbstract {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Choose account type:");
	        System.out.println("1. Savings Account");
	        System.out.println("2. Current Account");

	        BankAccountAbstract account = null;

	        int accountTypeChoice = scanner.nextInt();

	        switch (accountTypeChoice) {
	            case 1:
	                // Create Savings Account
	                account = new SavingsAccountAbstract(accountTypeChoice, null, accountTypeChoice, accountTypeChoice);
	                break;

	            case 2:
	                // Create Current Account
	                account = new CurrentAccountAbstract(accountTypeChoice, null, accountTypeChoice, accountTypeChoice);
	                break;

	            default:
	                System.out.println("Invalid choice. Exiting program.");
	                System.exit(0);
	        }

	        // Display sub-menu for account type-specific operations
	        while (true) {
	            System.out.println("\nChoose operation:");
	            System.out.println("1. Deposit");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Calculate Interest");
	            System.out.println("4. Display Account Information");
	            System.out.println("5. Exit");

	            int operationChoice = scanner.nextInt();

	            switch (operationChoice) {
	                case 1:
	                    System.out.print("Enter deposit amount: $");
	                    float depositAmount = scanner.nextFloat();
	                    account.deposit(depositAmount);
	                    break;

	                case 2:
	                    System.out.print("Enter withdrawal amount: $");
	                    float withdrawalAmount = scanner.nextFloat();
	                    account.withdraw(withdrawalAmount);
	                    break;

	                case 3:
	                    account.calculateInterest();
	                    break;

	                case 4:
	                    account.displayAccountInfo();
	                    break;

	                case 5:
	                    System.out.println("Exiting program.");
	                    scanner.close();
	                    System.exit(0);

	                default:
	                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
	            }
	        }
	    }
}
