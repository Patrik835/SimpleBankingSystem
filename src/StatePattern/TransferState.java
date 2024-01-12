package StatePattern;

import ManagerObserver.Manager;

public class TransferState implements MenuState{
    private Manager manager;

    public TransferState(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void handleRequest() {
        manager.setWelcomeMessage("You have selected to see your account information. See below:");
    }
    @Override
    public String getMenu() {
        return "transfer menu";
    }
}
