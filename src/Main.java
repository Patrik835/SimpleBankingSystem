public class Main {
    public static void main(String[] args) {

        Writer writer = new Writer() ;
        Reader reader = new Reader() ;
        Manager Manager = new Manager() ;


        writer.write("Write name of the client:");
        // read and set the name of the client
        String name = reader.readLine();
        Manager.setClientName(name);
        // write message hello name of the client and ask for the step he wants to do until he wants to exit
        int selection;
        do {writer.write(Manager.welcomeMessage);
            writer.write(Manager.Menu);
            selection = Integer.parseInt(reader.readLine());
            Manager.onMenuSelection(selection); 
        } while (selection != 6);
      }   
    }
    // TODO: input fields