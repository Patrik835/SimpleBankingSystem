package BankAccounts;

public interface BankAccount {
    String getOwnerName();
    double getBalance();
    void deposit(double amount);
    void withdraw(double amount);
}
