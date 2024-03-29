package ManagerObserver;

import BankAccounts.BankAccount;
import SingletonPattern.BankingSystemSingleton;
import StatePattern.*;
import Utils.Reader;
import Utils.Writer;

public class Manager implements MenuSelectionObserver {
    private MenuState state;
    public String welcomeMessage;
    public String name;
    public BankAccount account;

    public Manager(String name) {
        this.name = name;
    }

    public String getMenu() {
        return state.getMenu();
    }

    public String doLogic() {
        return state.doLogic();
    }

    // observer pattern method, waiting for user input
    @Override
    public void onMenuSelection(int selection) {
        if (selection == 0) {
            setState(new MainMenuState(this, name, account));
            return;
        }
        switch (selection) {
            case 1:
                setState(new AccountInformationState(this));
                break;
            case 2:
                setState(new DepositState(this));
                break;
            case 3:
                setState(new WithdrawState(this));
                break;
            case 4:
                setState(new ChangeCurrencyState(this));
                break;
            case 5:
                setState(new CheckBalanceState(this));
                break;
        }
    }

    public void setState(MenuState state) {
        this.state = state;
        this.state.handleRequest();
    }

    public void setWelcomeMessage(String message) {
        this.welcomeMessage = message;
    }

    public BankAccount startMenu(Reader reader, Writer writer) {
        writer.write("What kind of account do you want to create? (1) Basic Bank Account (2) Savings Account");
        String accountType = reader.readLine();
        BankingSystemSingleton bankingSystem = BankingSystemSingleton.getInstance();
        String accountTypeName;
        if (accountType.equals("1")) {
            accountTypeName = "basic";
        } else if (accountType.equals("2")) {
            accountTypeName = "savings";
        } else {
            System.out.println("Invalid key pressed, please try again.");
            startMenu(reader, writer);
            return null;
        }
        this.account = bankingSystem.createAccount(accountTypeName, name);
        return this.account;
    }
}