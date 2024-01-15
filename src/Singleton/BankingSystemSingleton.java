package Singleton;

import BankAccounts.BankAccount;
import DecoratorPattern.BankAccountDecorator;
import DecoratorPattern.FeeDecorator;
import FactoryPattern.BankAccountFactory;
import FactoryPattern.BasicBankAccountFactory;
import FactoryPattern.SavingsBankAccountFactory;
import AdapterPattern.CurrencyConverter;
import AdapterPattern.CurrencyConverterAdapter;
import AdapterPattern.ExchangeRateService;

// Singleton pattern
public class BankingSystemSingleton {
    private static BankingSystemSingleton instance;
    private static BankAccountFactory bankAccountFactory;
    private static BankAccount bankAccount;

    public String init = "Initialization of the Banking system";

    private BankingSystemSingleton() {
        System.out.println(init);
    }

    public synchronized static BankingSystemSingleton getInstance() {
        if (instance == null) {
            instance = new BankingSystemSingleton();
        }
        return instance;
    }

    public BankAccount createAccount(String accountType, String ownerName) {
        if (accountType.equalsIgnoreCase("savings")) {
            bankAccountFactory = new SavingsBankAccountFactory(0.2);
        }

        if (accountType.equalsIgnoreCase("basic")) {
            bankAccountFactory = new BasicBankAccountFactory();
        }

        if (bankAccountFactory == null) {
            throw new IllegalArgumentException("Unsupported account type: " + accountType);
        }

        bankAccount = bankAccountFactory.createAccount(accountType, ownerName);
        return bankAccount;
    }

    public double checkBalance() {
        if (bankAccount != null ) {
            return bankAccount.getBalance();
        } else {
            return -1;
        }
    }

    public boolean deposit(double amount) {
        if (bankAccount != null && amount > 0) {
            bankAccount.deposit(amount);
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (bankAccount != null && bankAccount.getBalance() >= amount && amount > 0) {
            BankAccountDecorator fee = new FeeDecorator(bankAccount, 2);
            fee.withdraw(amount);
            return true;
        } else {
            System.out.println("Your balance is too low to withdraw that amount.");
            return false;
        }
    }

    public double changeCurrency(double amount) {
        if (bankAccount != null && amount > 0 && amount < bankAccount.getBalance()) {
            CurrencyConverter currencyConverter = new CurrencyConverterAdapter(new ExchangeRateService());
            return currencyConverter.convert(amount);
        } else {
            return 0.0;
        }
    }
}