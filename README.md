# Simple banking system

TODO: A brief description of what this project does and who it's for

## Authors

- [Lukáš Kollár](https://www.github.com/Lukas117)
- [Patrik Palenčár](https://www.github.com/Patrik835)

## Cooperation

TODO: Describe cooperation between the team members

## Documentation

### Creational design patterns

#### Singleton pattern

- The singleton pattern ensures that a class has only one instance as well as provides access to that instance
- This is especially useful when only one instance of an object is needed in the system such as Database connection or
  in our scenario, one Banking system
- This pattern can be found in class `BankingSystemSingleton.java`
- The usage of the pattern:
    - In this class we have a private field representing the
      instance `private static BankingSystemSingleton instance;`
    - The constructor is private so the class cannot be initialized from
      outside `private BankingSystemSingleton() { ... }`
    - Lastly there is method to get the instance of the Banking system:
      ``` java
        public synchronized static BankingSystemSingleton getInstance() {
            if (instance == null) {
                instance = new BankingSystemSingleton();
            }
            return instance;
        }
        ```
    - This method checks if the instance is null
        - If so create new instance of the banking system
        - If not it returns the instance, and it can be used throughout the system
        - The synchronized keyword ensures thread safety so only one thread at a time can access the method
    - The class also contains other useful methods that are used in the banking system

#### Factory pattern

- The factory pattern provides an interface for creating objects but allows the subclasses to change the type of the
  object created
- Delegating the instantiation of the objects to classes that implement the interface
- This pattern can be found in package `FactoryPattern` and is using bank accounts objects that are in a separate
  package called `BankAccounts`
- The usage of the pattern:
    - In this program the factory pattern is used to create different types of bank accounts
    - The class `BankAccountFactory.java` represents the factory interface for creating objects - accounts
    - In this class we have a method `BankAccount createAccount(String accountType, String ownerName);`
    - The method is implemented in subclasses `SavingsBankAccountFactory.java`
      and `BasicBankAccountFactory.java`
    - The implementation of one of the subclasses used to create `SavingsBankAccount` (which implements BankAccount):
      ```java
        public class SavingsBankAccountFactory implements BankAccountFactory {
            private final double defaultInterestRate;
  
            public SavingsBankAccountFactory(double defaultInterestRate) {
                this.defaultInterestRate = defaultInterestRate;
            }
              
            @Override
            public BankAccount createAccount(String accountType, String ownerName) {
                return new SavingsBankAccount(accountType, ownerName, defaultInterestRate);
            }
        }
      ```
      - As can be seen, the class alters the type of the object and adds the `defaultInterestRate` for the savings  
        account as well as creates the account object

### Structural design patterns

#### Adapter pattern

TODO: this

#### Decorator pattern

TODO: this

### Behavioral design patterns

#### Observer pattern

- The Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
- This pattern can be found in the `Manager` class and its associated `MenuSelectionObserver.java` interface.
- The usage of the pattern:
  - In this program, the Observer pattern is used to notify the Manager when a menu selection has been made.
  - The Manager class implements the MenuSelectionObserver interface, and provides an implementation for the onMenuSelection method. This method is called when a menu selection is made (is subscribed to menu selection).
  ```java
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
        }
    }
    ```
  - This allows the Manager to update its state based on the menu selection, without needing to know the details of how the menu is managed.
This use of the Observer pattern allows the Manager to react to changes in the menu selection. It also makes the code more flexible and easier to maintain.



#### State pattern

- The State pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.
- This pattern can be found in the Manager class and its associated State subclasses.
- The usage of the pattern:
  - In this program, the State pattern is used to manage the different states of the menu in the banking system. Each state represents a different menu and has different options available.
  - There is State interface that defines the methods for each state: `MenuState.java`.The `Manager.java` class has a setState method that allows it to change its current state.
  ```java
  public interface MenuState {
    void handleRequest();
    String getMenu();
    String doLogic();
  };
  ```
  - Each state is represented by a class that implements the State interface. For example, the `MainMenuState` class represents the main menu state. When the Manager is in this state, it displays the main menu and handles the options for this menu.
  - When a menu option is selected that should change the state (for example, going from the main menu to the deposit menu), 
  the Manager's state is updated with the setState method.

This use of the State pattern allows the code to be more divided and easier to maintain. Each state is responsible for its own behavior, so adding a new state or changing the behavior of an existing state is as simple as adding or modifying a class.

## Run Locally

Clone the project

```bash
  git clone https://github.com/Patrik835/SimpleBankingSystem.git
```

Run from the Main.java file
