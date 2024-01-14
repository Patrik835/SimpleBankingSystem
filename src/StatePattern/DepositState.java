package StatePattern;

import ManagerObserver.Manager;
import Utils.*;

public class DepositState implements MenuState {

    private Manager manager;
    private Writer writer = new Writer();
    private Reader reader = new Reader();

    public DepositState(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void handleRequest() {
        manager.setWelcomeMessage("You have selected to deposit funds. See instructions below:");
    }
    @Override
    public String doLogic() {
        double amount = 0;
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
        if (manager.account.deposit(amount)){
            return "Deposit of " + amount + " was successful.\nNew balance: " + manager.account.getBalance();
        }
        else {
            return "Deposit was unsuccessful. Please enter positive amount only.";
        }
    }
    @Override
    public String getMenu() {
        return "\n0. Go back to main menu";
    }
}
    

