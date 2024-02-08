package com.hexaware.model;
// task 14
public class Account14 {	    
    
	//Attributes
	private int accountNumber;
	int customerID;
	private String accountType;
	private double accountBalance;
	
	//default Constr
	public Account14() {}
	
	//Constr overload
	public Account14(int accountNumber, int customerId, String accountType, double accountBalance) {
		this.accountNumber = accountNumber;
		this.customerID = customerId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	
/*  //Method to print all Account attributes
	public void printAccountInfo() {
		System.out.println("Account No.: " + accountNumber);
		System.out.println("Account Type: " + accountType);
		System.out.println("Account Balance: " + accountBalance);
	}
*/

	
	//Getter methods declr.
	
	public int getAccountNo() {
		return accountNumber;
	}
	
	public int getCustomerId() {
		return customerID;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public double getAccountBal() {
		return accountBalance;
	}
	
	//Setter methods declr.
	
	public void setAccountNo(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public void setCustomerId(int customerId) {
		this.customerID = customerId;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public void setAccountBal(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
	//Deposit method
	public void deposit(int amount) {
		accountBalance += amount;
		System.out.println("Deposit of " + amount + " is successfull! \nNew Balance: $" + accountBalance);
	}
	
	//Withdraw method
	public void withdraw(int amount) {
		if(amount <= accountBalance) {
			accountBalance -= amount;
			System.out.println("\nWithdrawal of " + amount + " is successfull! \nNew Balance: $" + accountBalance);
		}else {
			System.out.println("\nInsufficient Balance!. withdraw lesser amount...");
		}
	}
		
    //Calculate interest method
    public void calculateInterest() {
        if ("Savings".equals(accountType)) {
            double interest = accountBalance * 0.045; // 4.5% interest rate
            accountBalance += interest;
            System.out.println("\nInterest calculated and added.\nNew balance: $" + accountBalance);
        } else {
            System.out.println("\nInterest calculation is applicable only for Savings accounts.");
        }
    }
   
}
