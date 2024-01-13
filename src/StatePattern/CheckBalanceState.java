package StatePattern;

import ManagerObserver.Manager;
import BankAccounts.BankAccount;

public class CheckBalanceState implements MenuState{
    private Manager manager;
    private BankAccount account;

    public CheckBalanceState(Manager manager, BankAccount account) {
        this.manager = manager;
        this.account = account;
    }

    @Override
    public void handleRequest() {
        double balance = account.getBalance();
        manager.setWelcomeMessage("You have selected to see your balance\n Your current balance:" + balance  );
    }
    @Override
    public String getMenu() {
        return "check balance menu";
    }
}
