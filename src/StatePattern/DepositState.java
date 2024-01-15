package StatePattern;

import ManagerObserver.Manager;
import Utils.*;
import SingletonPattern.BankingSystemSingleton;

public class DepositState implements MenuState {

    private final Manager manager;
    private final Writer writer = new Writer();
    private final Reader reader = new Reader();

    public DepositState(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void handleRequest() {
        manager.setWelcomeMessage("You have selected to deposit funds. See instructions below:");
    }

    @Override
    public String doLogic() {
        BankingSystemSingleton bankingSystem = BankingSystemSingleton.getInstance();
        double amount;
        while (true) {
            writer.write("How much do you want to deposit?");
            String input = reader.readLine();
            try {
                amount = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                writer.write("Invalid input. Please enter a valid number.");
            }
        }
        if (bankingSystem.deposit(amount)) {
            return "Deposit of " + amount + " was successful.\nNew balance: " + bankingSystem.checkBalance();
        } else {
            return "Deposit was unsuccessful. Please enter positive amount only.";
        }
    }

    @Override
    public String getMenu() {
        return "\n0. Go back to main menu";
    }
}
    

