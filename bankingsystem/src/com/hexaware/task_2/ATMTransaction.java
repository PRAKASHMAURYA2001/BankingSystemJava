package com.hexaware.task_2;

//task 2

import java.util.Scanner;

public class ATMTransaction {
  public static void main(String[] args) {
      // Step 1: Input the current balance
      Scanner scanner = new Scanner(System.in);
      String ch =null;
      System.out.print("Enter your current balance: $");
      double currentBalance = scanner.nextDouble();
          
      do {
      // Step 2: Display options to the user
      System.out.println("Options:");
      System.out.println("1. Check Balance");
      System.out.println("2. Withdraw");
      System.out.println("3. Deposit");

      // Step 3: Ask the user to choose an option
      System.out.print("Enter the option number: ");
      int option = scanner.nextInt();

      // Step 4: Implement checks based on the chosen option
      switch (option) {
          case 1:
              // Check Balance
              System.out.println("Your current balance: $" + currentBalance);
              break;
          case 2:
              // Withdraw
              System.out.print("Enter the amount to withdraw: $");
              double withdrawAmount = scanner.nextDouble();

              if (withdrawAmount > currentBalance) {
                  System.out.println("Error: Insufficient funds. Withdrawal failed.");
              } else if (withdrawAmount % 100 != 0 && withdrawAmount % 500 != 0) {
                  System.out.println("Error: Withdrawal amount must be in multiples of 100 or 500. Withdrawal failed.");
              } else {
                  currentBalance -= withdrawAmount;
                  System.out.println("Withdrawal successful. Updated balance: $" + currentBalance);
              }
              break;
          case 3:
              // Deposit
              System.out.print("Enter the amount to deposit: $");
              double depositAmount = scanner.nextDouble();

              if (depositAmount <= 0) {
                  System.out.println("Error: Deposit amount must be greater than zero. Deposit failed.");
              } else {
                  currentBalance += depositAmount;
                  System.out.println("Deposit successful. Updated balance: $" + currentBalance);
              }
              break;
          default:
              System.out.println("Error: Invalid option.");
              
             
      }
      System.out.println("Do u wnt to continue ? Y or y");
		ch = scanner.next();
      }while(ch.equals("Y") || ch.equals("y"));
		System.out.println("Thanks for using our system !!!");
		System.exit(0);


      // Close the scanner
      scanner.close();
  }
}
