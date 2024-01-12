import Utils.Reader;
import Utils.Writer;
import StatePattern.MainMenuState;
import ManagerObserver.Manager;


public class Main {
    public static void main(String[] args) {

        Writer writer = new Writer() ;
        Reader reader = new Reader() ;

        writer.write("Write name of the client:");
        String name = reader.readLine();
        Manager manager = new Manager(name) ;

        manager.setState(new MainMenuState(manager, name)); 
        int selection;

        while (true) {
          writer.write(manager.welcomeMessage);
          writer.write(manager.getMenu());
          selection = Integer.parseInt(reader.readLine());
          if (selection == 6) {
              break;
          }
          manager.onMenuSelection(selection);
        }
        //TODO: Set state to NotInMenuState manager.setState(new AccountInformationState(manager)); 
        writer.write(manager.welcomeMessage);
      }   
    }