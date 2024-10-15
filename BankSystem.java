import java.util.HashMap;

import java.util.Map;

import java.util.Scanner;

  
public class BankSystem {

    private Map<String, BankAccount> accounts = new HashMap<>();

    private Scanner scanner = new Scanner(System.in);


    // Create a new account
 
   public void createAccount() {

        System.out.println("Enter Account Number:");

        String accountNumber = scanner.nextLine();

        System.out.println("Enter Account Holder Name:");

        String holderName = scanner.nextLine();

        System.out.println("Enter Initial Balance:");

        double initialBalance = scanner.nextDouble();

        scanner.nextLine();
 // Consume the newline

        BankAccount account = new BankAccount(accountNumber, holderName, initialBalance);
                accounts.put(accountNumber, account);

        System.out.println("Account created successfully!");

    }

 // View Account Balance

    public void viewBalance(String accountNumber) {

        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
 
           System.out.println("Balance for " + account.getAccountHolderName() + ": $" + account.getBalance());
        }
         else {
 
           System.out.println("Account not found!");

        }

    }

 // Deposit money

    public void depositMoney(String accountNumber) {

        BankAccount account = accounts.get(accountNumber);

        if (account != null) {

            System.out.println("Enter amount to deposit:");

            double amount = scanner.nextDouble();

            scanner.nextLine();
 // Consume the newline
 
           account.deposit(amount);

           System.out.println("Deposit successful.");

        }
        else {

            System.out.println("Account not found!");

        }

    }


// Withdraw money

    public void withdrawMoney(String accountNumber) {
 
       BankAccount account = accounts.get(accountNumber);

        if (account != null) {

            System.out.println("Enter amount to withdraw:");

            double amount = scanner.nextDouble();

           scanner.nextLine();
 // Consume the newline
 
           if (account.withdraw(amount)) {

                System.out.println("Withdrawal successful.");

            }

        }
          else {

            System.out.println("Account not found!");

        }

    }


    // View transaction history
 
   public void viewTransactions(String accountNumber) {

        BankAccount account = accounts.get(accountNumber);

        if (account != null) {

            account.viewTransactions();

        }
 else {

            System.out.println("Account not found!");
 
       }

    }

 
 // Login simulation(for simplicity, we assume account number is the 'login' info)

    public boolean authenticate(String accountNumber) {

        return accounts.containsKey(accountNumber);

    }


    public void showMenu() {
 
       while (true) {

            System.out.println("\n--- Online Banking System ---");
 
           System.out.println("1. Create Account");
 
           System.out.println("2. View Balance");

            System.out.println("3. Deposit Money");

            System.out.println("4. Withdraw Money");

            System.out.println("5. View Transactions");

            System.out.println("6. Exit");

            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            scanner.nextLine();
 // Consume newline


            switch (choice) {

                case 1:

                    createAccount();

                    break;

                case 2:

                    System.out.print("Enter Account Number: ");

                    String viewAccNumber = scanner.nextLine();

                    if (authenticate(viewAccNumber)) {

                        viewBalance(viewAccNumber);

                    }
 else {

                        System.out.println("Invalid Account Number.");

                    }

                    break;

                case 3:

                    System.out.print("Enter Account Number: ");

                    String depositAccNumber = scanner.nextLine();

                    if (authenticate(depositAccNumber)) {

                        depositMoney(depositAccNumber);

                    }
 else {

                        System.out.println("Invalid Account Number.");

                    }

                    break;

                case 4:

                    System.out.print("Enter Account Number: ");

                    String withdrawAccNumber = scanner.nextLine();

                    if (authenticate(withdrawAccNumber)) {

                        withdrawMoney(withdrawAccNumber);

                    }
 else {

                        System.out.println("Invalid Account Number.");

                    }

                    break;

                case 5:

                    System.out.print("Enter Account Number: ");

                    String transAccNumber = scanner.nextLine();

                    if (authenticate(transAccNumber)) {

                        viewTransactions(transAccNumber);

                    }
 else {
 
                       System.out.println("Invalid Account Number.");

                    }

                    break;

                case 6:

                    System.out.println("Exiting...");

                    return;

                default:

                    System.out.println("Invalid choice. Try again.");

            }

        }

    }

}