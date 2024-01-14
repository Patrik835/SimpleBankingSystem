package FactoryPattern;

import BankAccounts.BankAccount;
import BankAccounts.BasicBankAccount;

public class BasicBankAccountFactory implements BankAccountFactory {

    public BasicBankAccountFactory() {
    }

    @Override
    public BankAccount createAccount(String accountType, String ownerName) {
        return new BasicBankAccount(accountType, ownerName);
    }
}
