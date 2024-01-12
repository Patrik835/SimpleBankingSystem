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
    public void deposit(double amount) {
        decoratedAccount.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        decoratedAccount.withdraw(amount + fee);
        System.out.println("Transaction fee applied: -$" + fee);
    }

    @Override
    public String getOwnerName() {
        return decoratedAccount.getOwnerName();
    }

    @Override
    public double getBalance() {
        return decoratedAccount.getBalance();
    }
}
