package LLD.DesignPatterns.StateDesignPattern.ATMMachine;

import java.util.HashMap;
import java.util.Map;

public class ATMMachine {

   private CurrencyProcessor currencyProcessor;
   private UserInterface userInterface;
    private ATMState idleState;

    private ATMState cardInsertedState;

    private ATMState pinInsertedState;
    private ATMState currentState;

    private boolean isPinValid;

    public ATMMachine(UserInterface userInterface, CurrencyProcessor currencyProcessor){
        this.idleState=new IdleState(this);
        this.cardInsertedState=new CardInsertedState(this);
        this.pinInsertedState=new PinEnteredState(this);
        currentState=idleState;
        this.userInterface=userInterface;
        this.currencyProcessor=currencyProcessor;
    }
    public boolean isPinValid() {
        return isPinValid;
    }

    public void setPinValid(boolean pinValid) {
        isPinValid = pinValid;
    }

    public ATMState getIdleState() {
        return idleState;
    }

    public void setIdleState(ATMState idleState) {
        this.idleState = idleState;
    }

    public ATMState getPinInsertedState() {
        return pinInsertedState;
    }

    public ATMState getCardInsertedState() {
        return cardInsertedState;
    }

    public void changeState(ATMState newState){
        currentState=newState;
    }

    public  void insertCard(){
        currentState.insertCard();
    }

    public void enterPin(int pin){
        currentState.enterPin(pin);
    }

    public void withdrawCash(int amount){
        currentState.withdrawCash(amount);
    }

    public void ejectCard(){
        currentState.ejectCard();
    }

    // Additional methods for user interface operations
    public void displayMessage(String message) {
        userInterface.displayMessage(message);
    }

    public int getPin() {
        return userInterface.getPin();
    }

    public int getRequestedAmount() {
        return userInterface.getAmountRequested();
    }


    private static Map<Integer, Integer> initializeAvailableNotes() {
        Map<Integer, Integer> availableNotes = new HashMap<>();
        // Initialize available notes with denominations and counts
        availableNotes.put(100, 10); // 100 notes with count 10
        availableNotes.put(50, 20);  // 50 notes with count 20
        availableNotes.put(20, 30);  // 20 notes with count 30
        availableNotes.put(10, 50);  // 10 notes with count 50
        return availableNotes;
    }
    public static void main(String []args){
        // Initialize currency processor, and user interface
        UserInterface userInterface=new UserinterfaceImpl();
        CurrencyProcessor currencyProcessor = new CurrencyProcessorImpl(initializeAvailableNotes()); //Load ATM with currency

        // Create ATM machine instance
        ATMMachine atmMachine=new ATMMachine(userInterface, currencyProcessor);

        // Simulate ATM operations
        atmMachine.insertCard();
        atmMachine.enterPin(atmMachine.getPin());
        atmMachine.withdrawCash(atmMachine.getRequestedAmount());
        atmMachine.ejectCard();

    }
}
