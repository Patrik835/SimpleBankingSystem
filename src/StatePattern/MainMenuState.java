package StatePattern;

import ManagerObserver.Manager;
import BankAccounts.BankAccount;

public class MainMenuState implements MenuState {

    private Manager manager;
    private String name;
    private BankAccount account;

    public MainMenuState(Manager manager, String name, BankAccount account) {
        this.manager = manager;
        this.name = name;
        this.account = account;
    }
    @Override
    public void handleRequest() {
        manager.setWelcomeMessage("Hello " + name + ", you are in the menu of your"+ account.getOwnerName() +" . What do you want to do?");
    }
    @Override
    public String getMenu() {
        return "1. Create account\n2. Deposit\n3. Withdraw\n4. Transfer\n5. Check balance\n6. Exit";
    }
}