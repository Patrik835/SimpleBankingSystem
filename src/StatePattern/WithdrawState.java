package StatePattern;

import ManagerObserver.Manager;
import Utils.*;

public class WithdrawState implements MenuState{
    private Manager manager;
    private Writer writer = new Writer();
    private Reader reader = new Reader();

    public WithdrawState(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void handleRequest() {
        manager.setWelcomeMessage("You have selected to withdraw funds. See instructions below:");
    }
    @Override
    public String doLogic() {
        double amount = 0;
        while (true) {
            writer.write("How much do you want to withdraw?");
            String input = reader.readLine();
            try {
                amount = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                writer.write("Invalid input. Please enter a valid number.");
            }
        }
        if (manager.account.withdraw(amount)){
            return "Withdraw of " + amount + " was successful.\nNew balance: " + manager.account.getBalance();
        }
        else {
            return "Withdraw was unsuccessful.";
        }
    }
    @Override
    public String getMenu() {
        return "\n0. Go back to main menu";
    }
}
