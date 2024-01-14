package BankAccounts;

public interface BankAccount {
    String getOwnerName();
    String getAccountType();
    double getBalance();
    boolean deposit(double amount);
    boolean withdraw(double amount);
    String getAccountType();
}
