public class Manager implements MenuSelectionObserver {
    public String welcomeMessage;
    public String Menu;
    // private Reader reader;

    public Manager() {
        this.Menu = "1. Create account\n2. Deposit\n3. Withdraw\n4. Transfer\n5. Check balance\n6. Exit";
    }

    public void setClientName(String name) {
        this.welcomeMessage = "Hello " + name + ", what do you want to do?";
    }
    @Override
    public void onMenuSelection(int selection) {
        handleUserChoice(selection);
    }

    private void handleUserChoice(int choice) {
        System.out.println("You selected " + choice);
    }
}
