public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000.00); // initial balance ₹5000
        ATM atm = new ATM(account);
        atm.start();
    }
}

