package StatePattern;

import ManagerObserver.Manager;
import SingletonPattern.BankingSystemSingleton;

public class CheckBalanceState implements MenuState{
    private Manager manager;
    private BankingSystemSingleton account = BankingSystemSingleton.getInstance();

    public CheckBalanceState(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void handleRequest() {
        manager.setWelcomeMessage("\nYou have selected to see your balance. See your balance below:");
    }
    @Override
    public String doLogic() {
        return "Your current balance: " + account.checkBalance();
    }
    @Override
    public String getMenu() {
        return "\n0. Go back to main menu";
    }
}
