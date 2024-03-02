package LLD.StrategyDesignPattern.ShoppingCartApplication;

public class ShoppingCart {
    DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    double process(double price){
        return this.discountStrategy.applyDiscount(price);
    }

}
