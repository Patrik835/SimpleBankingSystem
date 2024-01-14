package DecoratorPattern;

import BankAccounts.BankAccount;

public class FeeDecorator implements BankAccountDecorator{
    private final BankAccount decoratedAccount;
    private final double fee;

    public FeeDecorator(BankAccount decoratedAccount, double fee) {
        this.decoratedAccount = decoratedAccount;
        this.fee = fee;
    }

    @Override
    public boolean deposit(double amount) {
        decoratedAccount.deposit(amount);
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        decoratedAccount.withdraw(amount + fee);
        System.out.println("Transaction fee applied: -$" + fee);
        return true;
    }

    @Override
    public String getOwnerName() {
        return decoratedAccount.getOwnerName();
    }

    @Override
    public double getBalance() {
        return decoratedAccount.getBalance();
    }

    @Override
    public String getAccountType() {
        return decoratedAccount.getAccountType();
    }
}
