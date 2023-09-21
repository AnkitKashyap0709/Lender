import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount);
        } else {
            System.out.println("Invalid withdrawal or insufficient balance");
        }
    }
}

class Loan {
    private String accountNumber;
    private double loanAmount;
    private double remainingBalance;

    public Loan(String accountNumber, double loanAmount) {
        this.accountNumber = accountNumber;
        this.loanAmount = loanAmount;
        this.remainingBalance = loanAmount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void makePayment(double amount) {
        if (amount > 0 && amount <= remainingBalance) {
            remainingBalance -= amount;
            System.out.println("Loan payment of $" + amount + " made.");
        } else {
            System.out.println("Invalid payment or remaining balance is insufficient.");
        }
    }
}

public class BankingApp {
    public static void main(String[] args) {
        Map<String, BankAccount> accounts = new HashMap<>();
        Map<String, Loan> loans = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBanking Application Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Apply for Loan");
            System.out.println("5. Make Loan Payment");
            System.out.println("6. Check Balance");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Account creation code (same as previous version)
                    break;

                case 2:
                    // Deposit code (same as previous version)
                    break;

                case 3:
                    // Withdraw code (same as previous version)
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    String loanAccNumber = scanner.nextLine();
                    System.out.print("Enter loan amount: ");
                    double loanAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    BankAccount loanAccount = accounts.get(loanAccNumber);
                    if (loanAccount != null) {
                        Loan newLoan = new Loan(loanAccNumber, loanAmount);
                        loans.put(loanAccNumber, newLoan);
                        System.out.println("Loan application approved.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    String loanRepayAccNumber = scanner.nextLine();
                    System.out.print("Enter repayment amount: ");
                    double repaymentAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    Loan loan = loans.get(loanRepayAccNumber);
                    if (loan != null) {
                        loan.makePayment(repaymentAmount);
                    } else {
                        System.out.println("Loan record not found.");
                    }
                    break;

                case 6:
                    // Check balance code (same as previous version)
                    break;

                case 7:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
