package LLD.DesignPatterns.DecoratorPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
public static void main(String []args){
    List<Product> products=new ArrayList<>();
    //create the products
    Product p1= ProductTypeFactory.createProduct(ProductType.EDIBLE_GOODS,"pulses",250);
    Product p2= ProductTypeFactory.createProduct(ProductType.ELECTRONIC_GOODS,"Phone",50);
    products.add(p1);
    products.add(p2);
    //add the products to shopping cart
    ShoppingCart shoppingCart=new ShoppingCart();
    shoppingCart.addToCart(p1);
    shoppingCart.addToCart(p2);
    shoppingCart.getCartSummary();
    System.out.println("Total Price: "+shoppingCart.getTotalPrice());
}
}
