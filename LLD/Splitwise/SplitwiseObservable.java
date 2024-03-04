package LLD.Splitwise;

public interface SplitwiseObservable {
    void register(UserObserver userObserver);
    void unRegister(UserObserver userObserver);
    void notifyUsers(String msg);
}
