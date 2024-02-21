package LLD.StateDesignPattern.ATMMachine;

public class IdleState implements ATMState{
    private ATMMachine atmMachine;
    public IdleState(ATMMachine atmMachine) {
        this.atmMachine=atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Card Inserted");
        atmMachine.changeState(atmMachine.getCardInsertedState());
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("Please enter card first");
    }

    @Override
    public void withdrawCash(int amount) {
        System.out.println("Please enter card first");
    }

    @Override
    public void ejectCard() {
        System.out.println("No card to eject");
    }
}
