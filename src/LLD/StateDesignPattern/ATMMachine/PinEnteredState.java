package LLD.StateDesignPattern.ATMMachine;

public class PinEnteredState implements ATMState{
    ATMMachine aTMMachine;
    public PinEnteredState(ATMMachine atmMachine) {
        this.aTMMachine=atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Card Already Inserted");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("Pin Already Entered");
    }

    @Override
    public void withdrawCash(int amount) {
        if(aTMMachine.isPinValid()){
            System.out.println("Cash Withdrawn");
            aTMMachine.changeState(aTMMachine.getIdleState());
        }else{
            System.out.println("Invalid Pin");
            aTMMachine.ejectCard();
        }

    }

    @Override
    public void ejectCard() {
        System.out.println("Card Ejected");

    }
}
