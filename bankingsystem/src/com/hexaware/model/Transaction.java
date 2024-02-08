package com.hexaware.model;

//task 14

import java.time.LocalDate;

public class Transaction {
    //Attributes
    private int transactionID;
    private int accountID;
    private String transactionType;
    private double transactionAmount;
    private LocalDate transactionDate;

    public Transaction() {}

    public Transaction(
	    int txnId, int accId, String txnType, 
	    double txnAmt, LocalDate txnDate) {

	this.accountID = accId;
	this.transactionType = txnType;
	this.transactionAmount = txnAmt;
	this.transactionDate = txnDate;
    }

    public int getTransactionID() {
	return transactionID;
    }

    public void setTransactionID(int transactionID) {
	this.transactionID = transactionID;
    }

    public int getAccountID() {
	return accountID;
    }

    public void setAccountID(int accountID) {
	this.accountID = accountID;
    }

    public String getTransactionType() {
	return transactionType;
    }

    public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
	return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
	this.transactionAmount = transactionAmount;
    }

    public LocalDate getTransactionDate() {
	return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
	this.transactionDate = LocalDate.now();
    } 



}
