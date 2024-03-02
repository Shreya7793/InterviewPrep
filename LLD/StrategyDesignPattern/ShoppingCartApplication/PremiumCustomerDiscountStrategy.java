package LLD.StrategyDesignPattern.ShoppingCartApplication;

public class PremiumCustomerDiscountStrategy implements DiscountStrategy{
    @Override
    public double applyDiscount(double price) {
        return price*0.9;
    }
}
