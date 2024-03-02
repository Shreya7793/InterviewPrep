package LLD.StrategyDesignPattern.ShoppingCartApplication;
/*
 We have a shopping cart application, and depending on the customer type (regular or premium),
 we want to apply different discount strategies.
 */
public class Client {
    public static void main(String []args){
        ShoppingCart shoppingCart=new ShoppingCart();
        //Regular Customer
        shoppingCart.setDiscountStrategy(new RegularCustomerDiscountStrategy());
        double regularCustomerPrice=shoppingCart.process(100);
        System.out.println("Regular customer will get discount of "+regularCustomerPrice);

        //Premium Customer
        shoppingCart.setDiscountStrategy(new PremiumCustomerDiscountStrategy());
        double premiumCustomerPrice=shoppingCart.process(100);
        System.out.println("Premium customer will get discount of "+premiumCustomerPrice);
    }
}
