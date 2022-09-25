// I certify the code of this lab is entirely my own work.
// but I received assistance from Instructor Sangeetha Balasingam.
package package2019e054;

import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Accounts
{
    public static int[] accountNumArr = new int[10];
    private double balance;
    private final int accountNumber;

    public Accounts(double initialBalance, int accountNumber )
    {
        if ( initialBalance > 0.0 ) {
            balance = initialBalance;
        }
        this.accountNumber = accountNumber;
    }

    public void credit( double amount ) throws NegativeAmountException
    {
        try {
            if ( amount < 0.0 ) {
                throw new NegativeAmountException("Amount cannot be negative");
            }
            else{
                balance = balance + amount;
                System.out.println("Balance : " + getBalance());
                System.out.println("Successfully deposit");
            }

        } catch (NegativeAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(double amount) throws NegativeAmountException, BalanceInsufficientException
    {
        try{
            if ( amount < 0.0 ) {
                throw new NegativeAmountException("Amount cannot be negative");
            }
            if ( amount > balance ) {
                throw new BalanceInsufficientException("Amount cannot be greater than balance");
            }
            balance = balance - amount;
            System.out.println("Balance : " + getBalance());
            System.out.println("Successfully withdrawn");
        } catch (NegativeAmountException | BalanceInsufficientException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getBalance()
    {
        return balance;
    }

    public int getAccountNumber()
    {
        return this.accountNumber;
    }

    //Method for find Account number is available.
    public static int findAccount(int accountNum) throws Exception
    {
        for(int i = 0; i < accountNumArr.length; i++)
        {
            if(accountNumArr[i] == accountNum)
            {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception,FileNotFoundException {
        Scanner input = new Scanner(System.in);

        //3.a. Read 10 account details of persons
        ArrayList<Accounts> accountDet = new ArrayList<>();

        FileReader fr = new FileReader("Accounts.txt");
        BufferedReader br = new BufferedReader(fr);
        int balance,accountNum;

        String contentLine = br.readLine();
        while(contentLine != null){
            String[] details = contentLine.split(" ",2);
            balance = Integer.parseInt(details[0]);
            accountNum = Integer.parseInt(details[1]);
            accountDet.add(new Accounts(balance,accountNum));
            contentLine = br.readLine();
        }
        br.close();
        fr.close();

        //3.b. Write those (of (a)) details in a file.
        FileWriter writer = new FileWriter("Accounts2.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        buffer .write("\tInitial Account Details\n");

        for (Accounts value : accountDet) {
            buffer.write(value.getBalance() + " \t" + value.getAccountNumber() + "\n");
        }

        buffer.close();
        System.out.println("Success in writing to file");


        //4. For store Account numbers to a array
        System.out.print("Enter the account number to find: ");
        int inp = input.nextInt();

        FileReader fr2 = new FileReader("Accounts.txt");
        BufferedReader br2 = new BufferedReader(fr2);

        int i = 0;
        //4.a. Read the account numbers from the file.
        String contentLine2 = br2.readLine();
        //Store the account numbers in an array.
        while(contentLine2 != null){
            String[] details = contentLine2.split(" ",2);
            accountNumArr[i] = Integer.parseInt(details[1]);
            i++;
            contentLine2 = br2.readLine();
        }
        br2.close();
        fr2.close();

        //4 Check if the given one is there in the array.

        if(findAccount(inp)>=0){
            System.out.println("Account is available");
        }
        else {
            System.out.println("Account is not available");
        }

        //5.
        String choice;
        while (true) {
            System.out.print("\n\tEnter your choice, \nfor withdraw(w,W) for deposit(d,D)), for exit(No,no) : ");
            choice = input.next();
            switch (choice) {
                case "w", "W" -> {
                    System.out.print("Enter the account number : ");
                    int accountNum2 = input.nextInt();
                    try {
                        int index = findAccount(accountNum2);
                        if (accountNum2<0) {
                            throw new ArithmeticException(
                                    "Account number should not be negative");
                        }
                        else if (index == -1) {
                            throw new ArithmeticException(
                                    "Account is not available"
                            );
                        } else {
                            System.out.print("Enter the amount to withdraw : ");
                            double amount = input.nextDouble();
                            accountDet.get(index).withdraw(amount);
                            }
                    } catch (ArithmeticException e) {
                        System.out.println("An exception is thrown");
                        System.out.println(e.getMessage());
                    }
                }

                case "d", "D" -> {
                    System.out.print("Enter the account number : ");
                    int accountNum3 = input.nextInt();
                    try {
                        int index = findAccount(accountNum3);
                        if (accountNum3<0) {
                            throw new ArithmeticException(
                                    "Account number should not be negative");
                        }
                        else if (index == -1) {
                            throw new ArithmeticException("Account is not available" );
                        } else {
                            System.out.print("Enter the amount to deposit : ");
                            double amount2 = input.nextDouble();
                                    accountDet.get(index).credit(amount2);
                            }
                    } catch (ArithmeticException e) {
                        System.out.println("An exception is thrown");
                        System.out.println(e.getMessage());
                    }
                }
                case "No", "no" -> System.exit(0);
                default -> System.out.println("Invalid input");
            }
        }
    }
}
