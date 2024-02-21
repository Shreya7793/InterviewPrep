package LLD.StateDesignPattern.VendingMachine;

public class DispensingState implements VendingMachineState{
    VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void insertCoin(int amount) {
        System.out.println("Cannot insert coins while dispensing");
    }

    @Override
    public void selectItem(String item) {
        System.out.println("Already dispensing item");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Item dispensed");
        vendingMachine.setCurrentState(vendingMachine.readyState);
    }
}
