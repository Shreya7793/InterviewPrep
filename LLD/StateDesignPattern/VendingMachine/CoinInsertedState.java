package LLD.StateDesignPattern.VendingMachine;

public class CoinInsertedState implements VendingMachineState{
    VendingMachine vendingMachine;

    public CoinInsertedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void insertCoin(int amount) {
        System.out.println(amount + " cents already inserted");
    }

    @Override
    public void selectItem(String item) {
        System.out.println("Item selected: " + item);
        vendingMachine.setCurrentState(vendingMachine.dispensingState);
    }

    @Override
    public void dispenseItem() {
        System.out.println("Please select item");
    }
}
