package FactoryPattern;

import BankAccounts.BasicBankAccount;

public class BasicBankAccountFactory implements BankAccountFactory {

    public BasicBankAccountFactory() {
    }

    @Override
    public BasicBankAccount createAccount(String accountType, String ownerName) {
        return new BasicBankAccount(ownerName);
    }
}
