import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM!");

        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: ₹%.2f\n", account.getBalance());
    }

    private void depositMoney() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.printf("Successfully deposited ₹%.2f\n", amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.printf("Successfully withdrawn ₹%.2f\n", amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

