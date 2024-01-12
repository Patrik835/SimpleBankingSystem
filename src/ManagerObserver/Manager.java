package ManagerObserver;

import StatePattern.*;


public class Manager implements MenuSelectionObserver {
    private MenuState state;
    public String welcomeMessage;
    public String Menu;
    public String name;

    public Manager(String name) {
        this.name = name;
        this.state = new AccountInformationState(this);
        this.Menu = "1. Create account\n2. Deposit\n3. Withdraw\n4. Transfer\n5. Check balance\n6. Exit";
    }
    
    public String getMenu() {
        return state.getMenu();
    }    

    @Override
    public void onMenuSelection(int selection) {
        if (selection == 0) {
            setState(new MainMenuState(this, name));
            return;
        }
        // before create account
        switch (selection) {
            case 1:
                setState(new AccountInformationState(this)); // get owner
                break;
            case 2:
                setState(new DepositState(this));
                break;
            case 3:
                setState(new WithdrawState(this));
                break;
            case 4:
                setState(new TransferState(this)); // change currency
                break;
            case 5:
                setState(new CheckBalanceState(this)); // get balance
                break;
            default:
                handleUserChoice(selection);
                break;
        }
    }

    private void handleUserChoice(int choice) {
        System.out.println("You selected " + choice);
    }

    public void setState(MenuState state) {
        this.state = state;
        this.state.handleRequest();
    }

    public void setWelcomeMessage(String message) {
        this.welcomeMessage = message;
    }
}
