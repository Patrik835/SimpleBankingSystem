package StatePattern;

public interface MenuState {
    void handleRequest();
    String getMenu();
    String doLogic();
}
