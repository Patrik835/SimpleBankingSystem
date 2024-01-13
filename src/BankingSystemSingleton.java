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

    // TODO: either use return value to send to other methods as parameter or return void
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
        if (bankAccount != null) {
            return bankAccount.getBalance();
        } else {
            System.out.println("Account not found");
            return -1;
        }
    }

    public void deposit(double amount) {
        if (bankAccount != null) {
            bankAccount.deposit(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    public void withdraw(double amount) {
        if (bankAccount != null) {
            BankAccountDecorator fee = new FeeDecorator(bankAccount, 2);
            fee.withdraw(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    public double changeCurrency(double amount) {
        if (bankAccount != null) {
            CurrencyConverter currencyConverter = new CurrencyConverterAdapter(new ExchangeRateService());
            return currencyConverter.convert(amount);
        } else {
            System.out.println("Account not found");
            return -1;
        }
    }
}