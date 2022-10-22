# Input-Output-and-error-handling
University of Jaffna: Faculty of Engineering : EC5080: Software Construction: Lab 3: Input/output, and error handling


Implement the Accounts class following the questions and statements below. Before implementing part 6 and 7, learn how to create a custom (your own) exception class.
1. First, create an IntelliJ Java project and name it as EC5080_Lab3_RegNo
2. Starting at the topmost line of the file, insert the following under the comments. You need to choose one of them. If you get any assistance from anyone/book/internet please include that. (This is to have good practice of writing bibliographical reference).
Certificate of Authenticity: (choose one from below)
      // I certify the code of this lab is entirely my own work.
      (or)
      // I certify the code of this lab is entirely my own work,
      // but I received assistance from [insert name (Instructor)].
      // Follow this with a description of the type of assistance (Other than given documents).
      public class Accounts { private double balance;
      private int accountNumber;
      public Account( double initialBalance, int accountNumber ) { if ( initialBalance > 0.0 ) balance = initialBalance; } public void credit( double amount ) { balance = balance + amount;
      }
      public void withdraw(double amount) { balance = balance - amount;
      }
      public double getBalance() { return balance;
      }
      public int getAccountNumber()
      {
      return this.accountNumber;
      }
      public static void main(String[] args)throws IOException,....... {
      }
      }
3. Implement a main method considering the following parts.
      a. Read 10 account details of a person (e.g. 1 acc1111).
      b. Write those (of (a)) details in a file.
          (e.g. 1 acc1111
          2 acc121)
4. Implement a method name findAccount(xxx) to check array of account numbers according to the given account number considering the following parts. The method should consider the necessary exceptions.
      a. Read the file name from the user.
      b. Store the account numbers in an array.
      c. Check if the given one is there in the array.
5. In your main method continue the following implementations.
      a. Get user choice to withdraw or credit until user type “No”.
      b. For each case (withdraw and credit), write correct try catch parts if(accountNumber==-1), if(amount==-1), and if (xxxxx. findAccount(xxx) ==null). And                  implement the necessary lines of code for withdraw and credit.
6. Create a custom exception class by inheriting the Exception class to check if a negative amount is credited.
7. Create a custom exception class by inheriting the Exception class to check whether there is insufficient balance when withdrawing.
8. In the withdraw and credit methods check the amount with the balance and negative amount considering the appropriate custom exceptions you have created. (Write the correct try catch and throws the appropriate custom exception)
9. In your main methods give all the exceptions and complete the line throws IOException,.......
