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
        manager.setWelcomeMessage("\nYou have selected to see your balance. See your balance below:");
    }
    @Override
    public String doLogic() {
        return "Your current balance: " + account.getBalance();
    }
    @Override
    public String getMenu() {
        return "\n0. Go back to main menu";
    }
}
