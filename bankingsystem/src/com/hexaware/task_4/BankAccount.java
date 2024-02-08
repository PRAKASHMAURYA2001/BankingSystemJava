package com.hexaware.task_4;

//task 4

import java.util.Scanner;

public class BankAccount {
  public static void main(String[] args) {
      // Sample bank data (account numbers and balances)
      int[] accountNumbers = { 1, 2, 3 };
      double[] accountBalances = { 1000.0, 2500.0, 500.0 };

      Scanner scanner = new Scanner(System.in);

      boolean validAccount = false;

      while (!validAccount) {
          System.out.print("Enter your account number: ");
          int enteredAccountNumber = scanner.nextInt();

          // Step 3: Validate the account number entered by the user
          int index = findAccountIndex(accountNumbers, enteredAccountNumber);

          if (index != -1) {
              // Step 4: Display the account balance if the account number is valid
              validAccount = true;
              System.out.println("Account Balance: $" + accountBalances[index]);
          } else {
              // Account number is not valid, ask the user to try again
              System.out.println("Invalid account number. Please try again.");
          }
      }

      // Close the scanner
      scanner.close();
  }

  // Helper method to find the index of the account number in the array
  private static int findAccountIndex(int[] accountNumbers, int enteredAccountNumber) {
      for (int i = 0; i < accountNumbers.length; i++) {
          if (accountNumbers[i] == enteredAccountNumber) {
              return i; // Found the account number, return its index
          }
      }
      return -1; // Account number not found
  }
}

