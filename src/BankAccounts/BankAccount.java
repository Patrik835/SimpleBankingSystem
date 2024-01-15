package BankAccounts;

public interface BankAccount {
    String getOwnerName();
    double getBalance();
    boolean deposit(double amount); // TODO: check together because the return value is not used
    boolean withdraw(double amount);
    String getAccountType();
    double getInterestRate();
}
