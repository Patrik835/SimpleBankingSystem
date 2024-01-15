import Utils.*;
import StatePattern.MainMenuState;
import BankAccounts.BankAccount;
import ManagerObserver.Manager;

public class Main {
    private static final Reader reader = new Reader();
    private static final Writer writer = new Writer();
    private static Manager manager;

    public static void main(String[] args) {
        initializeBankingSystem();
        runBankingSystem();
        System.out.println("Goodbye!");
    }

    private static void initializeBankingSystem() {
        System.out.println("Welcome to the Banking System!");
        writer.write("Write name of the client:");
        String name = reader.readLine();
        manager = new Manager(name);
        BankAccount account = manager.startMenu(reader, writer);
        manager.setState(new MainMenuState(manager, name, account));
    }

    private static void runBankingSystem() {
        int selection;
        while (true) {
            displayMenu();
            selection = readValidSelection();
            if (selection == 6) {
                break;
            }
            handleMenuSelection(selection);
        }
    }

    private static int readValidSelection() {
        while (true) {
            try {
                int selection = Integer.parseInt(reader.readLine());
                if (selection >= 0 && selection <= 6) {
                    return selection;
                } else {
                    writer.write("Invalid selection. Please enter a number between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                writer.write("Invalid input. Please enter a number.");
            }
        }
    }

    private static void displayMenu() {
        writer.write(manager.welcomeMessage);
        writer.write(manager.doLogic());
        writer.write(manager.getMenu());
    }

    private static void handleMenuSelection(int selection) {
        manager.onMenuSelection(selection);
    }
}