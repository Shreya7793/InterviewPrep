package LLD.DesignPatterns.StateDesignPattern.VendingMachine;

public class VendingMachine {
    VendingMachineState readyState;
    VendingMachineState coinInsertedState;
    VendingMachineState dispensingState;

    VendingMachineState currentState;
    public VendingMachine(){
        /*
        This approach is commonly used in the State Design Pattern to establish bidirectional communication
        between the context (in this case, the VendingMachine class) and the individual state objects.
        By passing this to the state objects during instantiation, each state object gains access to the context
        and can invoke its methods as necessary to transition between states or perform other operations.
         */
        readyState=new ReadyState(this);
        coinInsertedState=new CoinInsertedState(this);
        dispensingState=new DispensingState(this);
        currentState=readyState;
    }

    public void setCurrentState(VendingMachineState newState) {
        this.currentState = newState;
    }
    void insertCoin(int amount){
        currentState.insertCoin(amount);
    }

    void selectItem(String item){
        currentState.selectItem(item);
    }

    void dispenseItem(){
        currentState.dispenseItem();
    }

    public static void main(String args[]){
        VendingMachine vendingMachine=new VendingMachine();

        vendingMachine.insertCoin(100);
        vendingMachine.selectItem("Juice");
        vendingMachine.dispenseItem();
    }

}
