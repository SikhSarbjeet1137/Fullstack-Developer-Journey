public class BankAccount {

    // Withdraw Method
    static void withdraw(double balance, double amount)
            throws InvalidAmountException, InsufficientBalanceException {

        if (amount <= 0) {
            throw new InvalidAmountException("Invalid amount");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        double remainingBalance = balance - amount;

        System.out.println("Remaining Balance: ₹" + remainingBalance);
    }

    public static void main(String[] args) {

        double balance = 10000;

        try {

            withdraw(balance, 2000);

        } catch (InvalidAmountException e) {

            System.out.println(e.getMessage());

        } catch (InsufficientBalanceException e) {

            System.out.println(e.getMessage());

        } finally {

            System.out.println("Transaction Completed");
        }
    }
}