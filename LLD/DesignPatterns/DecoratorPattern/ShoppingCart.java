package LLD.DesignPatterns.DecoratorPattern;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> productList; //has list of products

    public ShoppingCart() {
        this.productList = new ArrayList<>();
    }

    public void addToCart(Product product){
        //Keep Adding the coupons here
        Product productWithEligibleDiscount =
                new PercentageCouponDecorator(
                        new FixedCouponDecorator(product));
        productList.add(productWithEligibleDiscount);
    }

    public double getTotalPrice(){
        int totalPrice=0;
        for(Product product:productList){
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void getCartSummary(){
        for(Product product:productList){
            System.out.println(product.toString());
        }
    }


}
