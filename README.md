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

TODO: this

#### State pattern

TODO: this

## Run Locally

Clone the project

```bash
  git clone https://github.com/Patrik835/SimpleBankingSystem.git
```

Run from the Main.java file
