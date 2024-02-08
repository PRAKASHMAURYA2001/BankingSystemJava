package com.hexaware.controller;
//task 14
import com.hexaware.model.Account14;
import com.hexaware.model.Customer14;
import com.hexaware.dao.AccountDao;
import java.util.Scanner;

public class AccountCtrl implements IAcc {

    Customer14 cust; // creating var of type Customer
    Account14 acc; // creating var of type

    AccountDao dao = new AccountDao();

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

    @Override
    public void addAccount() {

	acc = new Account14();

	System.out.println("What type of Account you want to open?" + "\n1. Savings" + "\n2. Current"
		+ "\n3. Zero Balance" + "\n=> ");

	int choice = sc.nextInt();

	System.out.println("Please enter your Customer ID: ");

	int custID = sc.nextInt();

	switch (choice) {
	case 1: {
	    acc.setCustomerId(custID);
	    acc.setAccountType("Savings");

	    System.out.print("Deposit amount in your Acc");
	    int amount = sc.nextInt();
	    acc.deposit(amount);

	    acc.setAccountBal(acc.getAccountBal()+amount);
	    break;
	}

	case 2: {
	    acc.setAccountType("Current");
	    System.out.print("Deposit amount in your Acc");
	    int amount = sc.nextInt();
	    acc.deposit(amount);

	    acc.setAccountBal(0);
	    break;
	}

	case 3: {
	    acc.setAccountType("Zero Balance");
	    System.out.print("Deposit amount in your Acc");
	    int amount = sc.nextInt();
	    acc.deposit(amount);

	    acc.setAccountBal(0);
	    break;
	}

	default: {
	    System.out.println("Invalid choice. Please choose 1, 2, or 3.");
	    break; // Exiting the method since the choice is invalid
	}
	}

	System.out.println("Account created successfully!");
	dao.createAccount(acc);

    }

    @Override
    public void viewAccount() {
	// System.out.println(dao.showAccountDetails) } // TODO Auto-generated method
	// stub
    }
}
