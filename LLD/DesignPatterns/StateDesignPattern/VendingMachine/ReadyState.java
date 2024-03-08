package LLD.DesignPatterns.StateDesignPattern.VendingMachine;

public class ReadyState implements VendingMachineState{
    VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println(amount + " cents inserted");
        vendingMachine.setCurrentState(vendingMachine.coinInsertedState);
    }

    @Override
    public void selectItem(String item) {
        System.out.println("Please insert coins first");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Please insert coins and select item");
    }
}
