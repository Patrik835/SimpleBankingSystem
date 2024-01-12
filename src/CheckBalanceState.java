public class CheckBalanceState implements MenuState{
    private Manager manager;

    public CheckBalanceState(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void handleRequest() {
        manager.setWelcomeMessage("You have selected to see your account information. See below:");
    }
    @Override
    public String getMenu() {
        return "check balance menu";
    }
}
