package BankAccounts;

public class SavingsBankAccount implements BankAccount{
    private final String ownerName;
    private double balance;
    private final double interestRate;
    private final String typeOfAccount;

    public SavingsBankAccount(String ownerName, double interestRate, String typeOfAccount) { //
        this.ownerName = ownerName;
        this.balance = 0.0;  // Initial balance
        this.interestRate = interestRate;
        this.typeOfAccount = typeOfAccount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            System.out.println("Invalid deposit amount.");
            return false;
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
            return false;
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

    @Override
    public String getAccountType() {
        return typeOfAccount;
    };
};