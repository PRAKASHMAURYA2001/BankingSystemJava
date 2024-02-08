package com.hexaware.task_7;

//task 7.1
public class Customer {

	 private int customerId;
	    private String firstName;
	    private String lastName;
	    private String emailAddress;
	    private String phoneNumber;
	    private String address;

	    // Default constructor
	    public Customer() {
	    }

	    // Parameterized constructor
	    public Customer(int customerId, String firstName, String lastName, String emailAddress, String phoneNumber, String address) {
	        this.customerId = customerId;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.emailAddress = emailAddress;
	        this.phoneNumber = phoneNumber;
	        this.address = address;
	    }

	    // Getter and Setter methods for all attributes
	    public int getCustomerId() {
	        return customerId;
	    }

	    public void setCustomerId(int customerId) {
	        this.customerId = customerId;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getEmailAddress() {
	        return emailAddress;
	    }

	    public void setEmailAddress(String emailAddress) {
	        this.emailAddress = emailAddress;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    // Method to print all customer information
	    public void printCustomerInfo() {
	        System.out.println("Customer ID: " + customerId);
	        System.out.println("First Name: " + firstName);
	        System.out.println("Last Name: " + lastName);
	        System.out.println("Email Address: " + emailAddress);
	        System.out.println("Phone Number: " + phoneNumber);
	        System.out.println("Address: " + address);
	    }
}
