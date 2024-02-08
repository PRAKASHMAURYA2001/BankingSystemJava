package com.hexaware.controller;
// task 14
import java.time.LocalDate;
import java.util.Scanner;

import com.hexaware.model.Transaction;
import com.hexaware.dao.TransactionDao;

public class TransactionCtrl implements ITxn{

    Transaction txn;
    TransactionDao dao = new TransactionDao();
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void deposit() {
	txn = new Transaction();
	
	System.out.println("Enter your Account No.:");
	int accNo = sc.nextInt();
	txn.setAccountID(accNo);
	txn.setTransactionType("deposit");
	txn.setTransactionDate(LocalDate.now());
	
	System.out.println("Enter amount to deposit: ");
	double depAmt = sc.nextDouble();
	txn.setTransactionAmount(depAmt);
	
	dao.newTransaction(txn);
    }

    @Override
    public void withdraw() {
	txn = new Transaction();
	
	System.out.println("Enter your Account No.:");
	int accNo = sc.nextInt();
	txn.setAccountID(accNo);
	txn.setTransactionType("withdrawal");
	txn.setTransactionDate(LocalDate.now());
	
	System.out.println("Enter amount to withdraw: ");
	double withdrAmt = sc.nextDouble();
	txn.setTransactionAmount(withdrAmt);
	dao.newTransaction(txn);
    }
    
   
}
