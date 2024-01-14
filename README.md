# Simple banking system

TODO: A brief description of what this project does and who it's for

## Authors

- [Lukáš Kollár](https://www.github.com/Lukas117)
- [Patrik Palenčár](https://www.github.com/Patrik835)

## Cooperation

Firstly, to start of the assignment we met together in order to come up with an idea for the program to implement. It
needed to be a console application and a banking system for simple operation seemed like a right fit. When we knew what
program, we needed to think about the design patterns we were going to implement, so we thought specific scenarios where
we could implement six design patterns.

Together, we created the skeleton project and a GitHub repository where we pushed the initial version with just empty
classes with names for the design patterns. From that point, we divided some work, which was for Lukas to start
implementing the design patterns and for Patrik to work on the user interface of the app as well as some of the design
patterns.

As can be seen in the repository, we created our own separate branches to work and not collide with each other. After
some time, we met again, went through the progress together and merged the branches into main. When we were finished
with our parts we tested the program and its functions as a whole.

It was agreed that the workload was divided evenly and fair.

## Documentation

### Creational design patterns

#### SingletonPattern pattern

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

- The adapter pattern allows objects with incompatible interfaces to collaborate
- Used to make existing classes work with others without modifying their source code
- This pattern can be found in package `AdapterPattern`
- The usage of the pattern:
    - In this program the adapter pattern is used to convert money from one currency to another
    - There is one class `ExchangeRateService.java` which represents the service class that cannot be modified
      and `CurrencyConverter.java` that is an interface used by our client
    - The important class representing the adapter - `CurrencyConverterAdapter.java` implements the method from
      the interface - `double convert(double amount);`:
      ``` java
          @Override
          public double convert(double amount) {
              double exchangeRate = exchangeRateService.getExchangeRate();
              return amount * exchangeRate;
          }
      ```
        - As can be seen in the method, the exchange service is called to get an exchange rate for converting euros to
          dollars and afterward, the method returns the converted amount of dollars

#### Decorator pattern

- The decorator pattern allows behaviour to be added to an individual object without affecting other objects
- Typically used to extend functionalities of classes
- This pattern can be found in package `DecoratorPattern`
- The usage of the pattern:
    - In this program the decorator pattern is used to apply fee when withdrawing money
    - There is a class `FeeDecorator.java` that extends the behaviour of a bank account
      and `BankAccountDecorator.java`
      that is an interface that is implemented in the concrete class and extends all the methods from bank account
      interface:
      ```java 
      public interface BankAccountDecorator extends BankAccount { }
      ```
    - The concrete decorator class is initialized with a fee that is used in the withdrawal method:
      ``` java
        @Override
        public boolean withdraw(double amount) {
            decoratedAccount.withdraw(amount + fee);
            System.out.println("Transaction fee applied: -$" + fee);
            return true;
        }
      ```
        - As can be seen in the method, the `decoratedAccount` which is a bank account we pass into the decorator calls
          its withdrawal method that is already implemented in the bank accounts but provides additional behaviour as
          applying fee to the amount wanted to withdraw
    - It is clear that the interface could contain some additional method to extend the behaviour of a bank account
      class, for example `applyFee()` that would provide the functionality but in this example it is an unnecessary step
      as it can be easily performed as it is now, directly in the method

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
