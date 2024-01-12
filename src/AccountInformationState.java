public class AccountInformationState implements MenuState {
    private Manager manager;

    public AccountInformationState(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void handleRequest() {
        manager.setWelcomeMessage("You have selected to see your account information. See below:");
    }
    @Override
    public String getMenu() {
        return "account information menu";
    }
}
