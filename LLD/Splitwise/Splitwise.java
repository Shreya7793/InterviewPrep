package LLD.Splitwise;

import java.util.ArrayList;
import java.util.List;

public class Splitwise implements SplitwiseObservable{
    private static Splitwise splitwise;
    private List<UserObserver> userObserverList;

    // Private constructor to prevent instantiation from outside
    private Splitwise(){
        this.userObserverList =new ArrayList<>();
    }

    // Method to get the singleton instance
    public static Splitwise getInstance(){
        if(splitwise==null){
            synchronized(Splitwise.class){
                if(splitwise==null){
                    splitwise=new Splitwise();
                }
            }
        }
        return  splitwise;
    }
    public void addExpense(String payer, List<String> participants, double amount) {
        // Logic to add expense

        // Notify user observers about the expense
        notifyUsers("New expense added: " + payer + " paid $" + amount);
    }

    @Override
    public void register(UserObserver userObserver) {
        userObserverList.add(userObserver);
    }

    @Override
    public void unRegister(UserObserver userObserver) {
        userObserverList.remove(userObserver);
    }

    @Override
    public void notifyUsers(String msg) {
        for(UserObserver userObserver:userObserverList){
            userObserver.update(msg);
        }
    }
}
