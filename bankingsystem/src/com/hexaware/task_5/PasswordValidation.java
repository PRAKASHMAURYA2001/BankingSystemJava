package com.hexaware.task_5;

//task 5

import java.util.Scanner;

public class PasswordValidation {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      // Step 1: Prompt the user to create a password
      System.out.println("Create a password for your bank account: ");
      System.out.println("The password must be at least 8 characters long.\r\n"
      		+ "• It must contain at least one uppercase letter.\r\n"
      		+ "• It must contain at least one digit.==\n");
      String password = scanner.nextLine();

      // Step 2: Validate the password according to the specified rules
      if (isPasswordValid(password)) {
          System.out.println("Password is valid. Account created successfully!");
      } else {
          System.out.println("Invalid password. Please follow the password rules.");
      }

      // Close the scanner
      scanner.close();
  }

  // Helper method to validate the password
  private static boolean isPasswordValid(String password) {
      // Rule 1: The password must be at least 8 characters long.
      if (password.length() < 8) {
          return false;
      }

      // Rule 2: It must contain at least one uppercase letter.
      boolean containsUppercase = false;
      for (char ch : password.toCharArray()) {
          if (Character.isUpperCase(ch)) {
              containsUppercase = true;
              break;
          }
      }

      if (!containsUppercase) {
          return false;
      }

      // Rule 3: It must contain at least one digit.
      boolean containsDigit = false;
      for (char ch : password.toCharArray()) {
          if (Character.isDigit(ch)) {
              containsDigit = true;
              break;
          }
      }

      return containsDigit;
  }
}

