package StatePattern;

public interface MenuState {
    void handleRequest();
    String getMenu();
    // void exitState();
    String doLogic();
}
