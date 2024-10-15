import java.util.ArrayList;

import java.util.List;


public class BankAccount {
    
        private String accountNumber;
  
        private String accountHolderName;
    
    private double balance;

        private List<String> transactions;

 
    // Constructor
  
  public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
                this.accountNumber = accountNumber;

        this.accountHolderName = accountHolderName;
 
        this.balance = initialBalance;

        this.transactions = new ArrayList<>();

        addTransaction("Account created with initial balance: " + initialBalance);
    }

   
 // Deposit method
    
    public void deposit(double amount) {
      
          if (amount > 0) {
 
               balance += amount;
 
               addTransaction("Deposited: " + amount);

        } 
          else {
 
           System.out.println("Invalid amount. Deposit failed.");

        }

    }

 
  // Withdraw method
 
   public boolean withdraw(double amount) {
 
       if (amount > 0 && balance >= amount) {

            balance -= amount;

            addTransaction("Withdrew: " + amount);
 
           return true;

        } 
       else {

            System.out.println("Insufficient balance or invalid amount.");
 
            return false;

        }

    }


    // Get balance method
 
   public double getBalance() {

        return balance;

    }

   
 // Add transaction to history
 
   private void addTransaction(String transactionDetails) {
  
      transactions.add(transactionDetails);

    }


    // View transaction history
 
   public void viewTransactions() {
 
       System.out.println("Transaction History for Account " + accountNumber + ":");

        for (String transaction : transactions) {

            System.out.println(transaction);

        }

    }


    public String getAccountNumber() {
 
       return accountNumber;

    }

 
   public String getAccountHolderName() {

        return accountHolderName;

    }

}