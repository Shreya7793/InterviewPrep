package LLD.DesignPatterns.StateDesignPattern.VendingMachine;

public interface VendingMachineState {
    void insertCoin(int amount);
    void selectItem(String item);
    void dispenseItem();
}
