package LLD.StrategyDesignPattern.ShoppingCartApplication;

public class RegularCustomerDiscountStrategy implements DiscountStrategy{
    @Override
    public double applyDiscount(double price) {
        return price*0.8;
    }
}
