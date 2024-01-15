package StatePattern;

import java.math.BigDecimal;
import java.math.RoundingMode;

import ManagerObserver.Manager;
import SingletonPattern.BankingSystemSingleton;
import Utils.*;

public class ChangeCurrencyState implements MenuState{
    private Manager manager;
    private Writer writer = new Writer();
    private Reader reader = new Reader();

    public ChangeCurrencyState(Manager manager) {
        this.manager = manager;
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    @Override
    public void handleRequest() {
        manager.setWelcomeMessage("You have selected to change currency of your system. See instructions below:");
    }
    @Override
    public String doLogic() {
        BankingSystemSingleton bankingSystem = BankingSystemSingleton.getInstance();
        double amount = 0;
        while (true) {
            writer.write("How much euro do you want to exchange?");
            String input = reader.readLine();
            try {
                amount = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                writer.write("Invalid input. Please enter a valid number.");
            }
        }
        if (amount < 0) {
            return "Exchange was unsuccessful. Please enter positive amount only.";
        }
        else if (amount > bankingSystem.checkBalance()) {
            manager.setState(new MainMenuState(manager, manager.name, manager.account));
            return "Exchange was unsuccessful. You don't have enough money in your account.";
        }
        else {
        double dollars = bankingSystem.changeCurrency(amount);
        manager.setState(new MainMenuState(manager, manager.name, manager.account));
        return "Exchange of " + amount + " euros was successful.\nYou have exchanged: " + round(dollars,2)+ "$";
        }
    }
    @Override
    public String getMenu() {
        return "\n0. Go back to main menu";
    } 
}
