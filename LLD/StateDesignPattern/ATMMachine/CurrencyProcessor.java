package LLD.StateDesignPattern.ATMMachine;

public interface CurrencyProcessor {
    boolean validateAmount(int amount);
    void dispenseCash(int amount);
}
