package FactoryPattern;

import BankAccounts.BankAccount;

// Factory pattern
public interface BankAccountFactory {
    BankAccount createAccount(String accountType, String ownerName);
}
