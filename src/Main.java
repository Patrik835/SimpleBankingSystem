import Utils.*;
import StatePattern.MainMenuState;
import BankAccounts.BankAccount;
import ManagerObserver.Manager;


public class Main {
    public static void main(String[] args) {

        Reader reader = new Reader();
        Writer writer = new Writer();

        writer.write("Write name of the client:");
        String name = reader.readLine();
        Manager manager = new Manager(name);
        
        BankAccount account = manager.startMenu(reader, writer);
        manager.setState(new MainMenuState(manager, name, account)); 
        int selection;

        while (true) {
          writer.write(manager.welcomeMessage);
          writer.write(manager.doLogic());
          writer.write(manager.getMenu());
          selection = Integer.parseInt(reader.readLine());
          if (selection == 6) {
              break;
          }
          manager.onMenuSelection(selection);
        }
        //TODO: Set state to NotInMenuState manager.setState(new AccountInformationState(manager)); 
        System.out.println("Goodbye!");   
   }   
}