package BankAccounts;

public interface BankAccount {
    String getOwnerName();
    String getAccountType();
    double getBalance();
    void deposit(double amount);
    void withdraw(double amount);
}
