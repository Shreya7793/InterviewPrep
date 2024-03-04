package LLD.StateDesignPattern.ATMMachine;

public class CardInsertedState implements ATMState{
    ATMMachine atmMachine;
    public CardInsertedState(ATMMachine atmMachine) {
        this.atmMachine=atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Card already inserted");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("Pin Entered");
        atmMachine.changeState(atmMachine.getPinInsertedState());
    }

    @Override
    public void withdrawCash(int amount) {
        System.out.println("Please enter pin first");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card Ejected!");
    }
}
