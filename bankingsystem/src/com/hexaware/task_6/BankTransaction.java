package com.hexaware.task_6;

//task 6

import java.util.ArrayList;
import java.util.Scanner;

public class BankTransaction {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      // List to store transactions
      ArrayList<String> transactionHistory = new ArrayList<>();

      boolean continueTransactions = true;

      while (continueTransactions) {
          // Display menu options
          System.out.println("\nOptions:");
          System.out.println("1. Deposit");
          System.out.println("2. Withdraw");
          System.out.println("3. Exit");

          // Prompt the user to choose an option
          System.out.print("Enter your choice (1-3): ");
          int choice = scanner.nextInt();

          switch (choice) {
              case 1:
                  // Deposit
                  System.out.print("Enter the deposit amount: $");
                  double depositAmount = scanner.nextDouble();
                  transactionHistory.add("Deposit: $" + depositAmount);
                  break;

              case 2:
                  // Withdraw
                  System.out.print("Enter the withdrawal amount: $");
                  double withdrawalAmount = scanner.nextDouble();
                  transactionHistory.add("Withdrawal: $" + withdrawalAmount);
                  break;

              case 3:
                  // Exit
                  continueTransactions = false;
                  break;

              default:
                  System.out.println("Invalid choice. Please enter a number between 1 and 3.");
          }
      }

      // Display transaction history
      System.out.println("\nTransaction History:");
      for (String transaction : transactionHistory) {
          System.out.println(transaction);
      }

      // Close the scanner
      scanner.close();
  }
}
