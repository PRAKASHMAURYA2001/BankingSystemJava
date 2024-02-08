package com.hexaware.dao;
// task 14
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.hexaware.model.Account14;
import com.hexaware.util.DBConnection;

public class AccountDao {

    Connection con;
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;

    public void createAccount(Account14 acc) {
	try {
	    con = DBConnection.getDBConn();
	    ps = con.prepareStatement(
		    "INSERT INTO Accounts" + "(account_id,customer_id, account_type, balance)" + "VALUES (?,?,?,?)",
		    Statement.RETURN_GENERATED_KEYS);
	    ps.setInt(1, acc.getAccountNo());
	    ps.setInt(2, acc.getCustomerId());
	    ps.setString(3, acc.getAccountType());
	    ps.setDouble(4, acc.getAccountBal());
	    int affectedRows = ps.executeUpdate();
	    // System.out.println(no_of_rows + " inserted Successfully !!!" );

	    if (affectedRows > 0) {
		// Retrieve auto-generated keys (in this case, customerID)
		ResultSet generatedKeys = ps.getGeneratedKeys();
		if (generatedKeys.next()) {
		    int generatedAccountNo = generatedKeys.getInt(1);
		    acc.setAccountNo(generatedAccountNo);
		    System.out.println("Your new Account No is: " + generatedAccountNo);
		}
	    }

	} catch (SQLException e) {// TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }
}
