package com.hexaware.task_1;

//task 1

import java.util.Scanner;

public class LoanEligibilityChecker {
  public static void main(String[] args) {
      // Step 1: Input the customer's credit score and annual income
      Scanner scanner = new Scanner(System.in);

      System.out.print("Enter the customer's credit score: ");
      int creditScore = scanner.nextInt();

      System.out.print("Enter the customer's annual income: $");
      double annualIncome = scanner.nextDouble();

      // Step 2: Use conditional statements to determine loan eligibility
      if (creditScore > 700 && annualIncome >= 50000) {
          // Customer is eligible for a loan
          System.out.println("Congratulations! The customer is eligible for a loan.");
      } else {
          // Customer is not eligible for a loan
          System.out.println("Sorry, the customer is not eligible for a loan.");
      }

      // Close the scanner
      scanner.close();
  }
}

