package BankAccounts;

public class SavingsBankAccount implements BankAccount{
    private final String ownerName;
    private double balance;
    private final double interestRate;

    public SavingsBankAccount(String ownerName, double interestRate) { //
        this.ownerName = ownerName;
        this.balance = 0.0;  // Initial balance
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of €" + amount + " successful. New balance: €" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of €" + amount + " successful. New balance: €" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getOwnerName() {
        return ownerName;
    }
}
