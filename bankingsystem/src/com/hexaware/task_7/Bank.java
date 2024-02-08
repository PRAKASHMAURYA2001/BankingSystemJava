package com.hexaware.task_7;


//task 7.3
public class Bank {
	 public static void main(String[] args) {
	        // Create a customer
	        Customer customer1 = new Customer(1, "Prakash", "Maurya", "prakashmaurya@email.com", "1234567890", "Mumbai");
	        customer1.printCustomerInfo();

	        // Create an account for the customer
	        Account account1 = new Account(1001, "Savings", 1000.0);
	        account1.printAccountInfo();

	        // Deposit money into the account
	        account1.deposit(500.0);

	        // Withdraw money from the account
	        account1.withdraw(200.0);

	        // Calculate and add interest for savings account
	        account1.calculateInterest();
	        
	 }
}
