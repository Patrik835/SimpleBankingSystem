package BankAccounts;

public class BasicBankAccount implements BankAccount {
    private final String ownerName;
    private double balance;
    private final String typeOfAccount; 

    public BasicBankAccount(String accountType, String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0.0;  // Initial balance
        this.typeOfAccount = accountType;
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
    @Override
    public double getInterestRate() {
        return 0;
    };
}

