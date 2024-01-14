package StatePattern;

import ManagerObserver.Manager;
import BankAccounts.BankAccount;

public class AccountInformationState implements MenuState {
    private Manager manager;
    private BankAccount account;

    public AccountInformationState(Manager manager) {
        this.manager = manager;
        this.account = manager.account;
    }

    @Override
    public void handleRequest() {
        manager.setWelcomeMessage("\nYou have selected to see your account information. See below:");
    }
    @Override
    public String doLogic() {
        return ("Owner of the account: " + account.getOwnerName() + "\n" + "Account type: " + account.getAccountType() + "\n" + "Currency: " + "account.getCurrency()" + "\n");
    }

    @Override
    public String getMenu() {
        return "\n0. Go back to main menu";
    }
}
