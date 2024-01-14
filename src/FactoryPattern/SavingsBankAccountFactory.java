package FactoryPattern;

import BankAccounts.BankAccount;
import BankAccounts.SavingsBankAccount;

public class SavingsBankAccountFactory implements BankAccountFactory {
    private final double defaultInterestRate;

    public SavingsBankAccountFactory(double defaultInterestRate) {
        this.defaultInterestRate = defaultInterestRate;
    }

    @Override
    public BankAccount createAccount(String accountType, String ownerName) {
        return new SavingsBankAccount(ownerName, defaultInterestRate, accountType);    }
}
