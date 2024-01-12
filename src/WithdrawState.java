public class WithdrawState implements MenuState{
    private Manager manager;

    public WithdrawState(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void handleRequest() {
        manager.setWelcomeMessage("You have selected to see your account information. See below:");
    }
    @Override
    public String getMenu() {
        return "withdraw menu";
    }
}
