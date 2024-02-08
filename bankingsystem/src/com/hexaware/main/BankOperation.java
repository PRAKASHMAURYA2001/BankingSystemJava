package com.hexaware.main;
// task 14
import com.hexaware.controller.*;
//import com.bankmgmtsys.Task_14.model.*;
import java.util.Scanner;

public class BankOperation {

  public static void main(String[] args) {
	ICust custI = new CustomerCtrl();
	IAcc accI = new AccountCtrl();
	ITxn txnI = new TransactionCtrl();

	Scanner sc = new Scanner(System.in);

	System.out.println("Welcome to HM Bank \n");
	System.out.print("Are you an existing customer? \n1. Yes \n2. No \n=> ");
	int choice = sc.nextInt();

	switch (choice) {
	//For existing customers
	case 1: {
	    System.out.println(
	    "\nChoose Your Operation" + 
	    "\n1. Deposit \n2. Withdraw");
	    
	    int choice2 = sc.nextInt() ;
	    
	    switch(choice2) {
	    case 1: {
		txnI.deposit();
		break;
	    }
	    case 2: {
		txnI.withdraw();
		break;
	    }
	    
	    }
	    break;
	}
	//For new customers
	case 2:{
	    custI.addCustomer();
	    custI.viewCustomer();
	    accI.addAccount();
	    accI.viewAccount();

	    break;
	}
	default:{
	    System.out.println("Enter a valid Choice !!!");
	    break;
	}
	}

	//Calculate interest for Savings account
	//acc1.calculateInterest();
	sc.close();
  }
}
