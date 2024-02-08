package com.hexaware.task_3;

//task 3

import java.util.Scanner;
public class CompoundInterestCalculator {
  public static void main(String[] args) {
      // Step 1: Input the number of customers
      Scanner scanner = new Scanner(System.in);
      String ch =null;
      

      // Step 2: Loop through each customer to calculate future balance
      
      do {
          
      	System.out.print("Enter the customer ID");
      	int i = scanner.nextInt();
          // Step 3: Prompt the user to enter initial balance, annual interest rate, and number of years
          System.out.print("Enter the initial balance for customer " + i + ": $");
          double initialBalance = scanner.nextDouble();

          System.out.print("Enter the annual interest rate for customer " + i + " (%): ");
          double annualInterestRate = scanner.nextDouble();

          System.out.print("Enter the number of years for customer " + i + ": ");
          int numberOfYears = scanner.nextInt();

          // Step 4: Calculate the future balance using the compound interest formula
          double futureBalance = initialBalance * Math.pow(1 + annualInterestRate / 100, numberOfYears);

          // Step 5: Display the future balance for the customer
          System.out.println("Future balance for customer " + i + ": $" + futureBalance);
      
  
      System.out.println("Do u wnt to continue ? Y or y");
		ch = scanner.next();
      } while(ch.equals("Y") || ch.equals("y"));
		System.out.println("Thanks for using our system !!!");
		System.exit(0);
		// Close the scanner
      scanner.close();
  }	
}

