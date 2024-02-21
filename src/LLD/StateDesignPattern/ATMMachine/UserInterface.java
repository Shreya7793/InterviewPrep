package LLD.StateDesignPattern.ATMMachine;

/* Interface defining user operations
UserInterface interface defines operations related to user interaction,
such as displaying messages, getting the PIN, and requesting the withdrawal amount.
*/
public interface UserInterface {
    void displayMessage(String msg);
    int getPin();
    int getAmountRequested();
}
