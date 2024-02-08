package com.hexaware.dao;
// task 14
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.model.Transaction;
import com.hexaware.util.DBConnection;

public class TransactionDao {
    Connection con;
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;
    
    public void newTransaction(Transaction txn) {
	try {
	    con = DBConnection.getDBConn();
	    ps = con.prepareStatement(
		"INSERT INTO Transactions (account_id, transaction_type, amount, transaction_date)" + 
		"VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
	    
	    ps.setInt(1, txn.getAccountID());
	    ps.setString(2, txn.getTransactionType());
	    ps.setDouble(3, txn.getTransactionAmount());
	    ps.setObject(4, txn.getTransactionDate());
	    int affectedRows = ps.executeUpdate();
	    
	    if (affectedRows > 0) {
		// Retrieve auto-generated keys (in this case, customerID)
		ResultSet generatedKeys = ps.getGeneratedKeys();
		if (generatedKeys.next()) {
		    int generatedTxnId = generatedKeys.getInt(1);
		    txn.setTransactionID(generatedTxnId);
		    System.out.println("Your new Account No is: " + generatedTxnId);
		}
	    }
			  
	} catch (SQLException e) {// TODO Auto-generated catch block
	    e.printStackTrace();
	}   
    }
}
