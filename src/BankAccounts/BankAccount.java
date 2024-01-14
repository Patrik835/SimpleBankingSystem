package BankAccounts;

public interface BankAccount {
    String getOwnerName();
    double getBalance();
    boolean deposit(double amount);
    boolean withdraw(double amount);
    String getAccountType();
    double getInterestRate();
}
