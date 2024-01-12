import BankAccounts.BankAccount;
import FactoryPattern.BankAccountFactory;
import FactoryPattern.BasicBankAccountFactory;
import FactoryPattern.SavingsBankAccountFactory;

// Singleton pattern
public class BankingSystemSingleton {
    private static BankingSystemSingleton instance;

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

    // Other banking system methods

    public BankAccount createAccount(String accountType, String ownerName) {
        BankAccountFactory bankAccountFactory = null;

        if (accountType.equalsIgnoreCase("savings")) {
            bankAccountFactory = new SavingsBankAccountFactory(0.2);
        }

        if (accountType.equalsIgnoreCase("basic")) {
            bankAccountFactory = new BasicBankAccountFactory();
        }

        if (bankAccountFactory == null) {
            throw new IllegalArgumentException("Unsupported account type: " + accountType);
        }

        return bankAccountFactory.createAccount(accountType, ownerName);
    }
}