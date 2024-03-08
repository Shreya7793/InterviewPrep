package LLD.DesignPatterns.StateDesignPattern.ATMMachine;

public interface CurrencyProcessor {
    boolean validateAmount(int amount);
    void dispenseCash(int amount);
}
