package LLD.DesignPatterns.StateDesignPattern.ATMMachine;

/*
Different behaviours in different state
ATMState is an interface defining the methods that represent the possible actions on the ATM
*/
public interface ATMState {
    void insertCard();
    void enterPin(int pin);
    void withdrawCash(int amount);
    void ejectCard();
}
