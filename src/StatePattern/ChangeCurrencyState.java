package StatePattern;

import ManagerObserver.Manager;

public class ChangeCurrencyState implements MenuState{
    private Manager manager;

    public ChangeCurrencyState(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void handleRequest() {
        manager.setWelcomeMessage("You have selected to change currency of your system. See instructions below:");
    }
    @Override
    public String doLogic() {
        return "Change currency";
    }
    @Override
    public String getMenu() {
        return "\n0. Go back to main menu";
    }
    
}
