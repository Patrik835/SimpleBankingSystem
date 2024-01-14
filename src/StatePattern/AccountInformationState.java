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
        double interestRate = 0.0;
        if (account.getAccountType().equals("savings")) {
            interestRate = account.getInterestRate();
        }
        return ("Owner of the account: " + account.getOwnerName() + "\n" + "Account type: " + account.getAccountType()+ "\n" + "Interest rate: " + interestRate);
    }

    @Override
    public String getMenu() {
        return "\n0. Go back to main menu";
    }
}
