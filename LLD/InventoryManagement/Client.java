package LLD.InventoryManagement;

import java.util.Map;
import java.util.UUID;

public class Client {
    public static void main(String [] args) {
        InventoryManagement inventoryManagement = InventoryManagement.getInstance();
        //Adding sample products to inventor
        Product p1 = new Product(UUID.randomUUID(), "Pulses", "Chana dal", 50.0, 20);
        Product p2 = new Product(UUID.randomUUID(), "Soap", "Body soap", 40.0, 10);

        inventoryManagement.addProductstoInventory(p1);
        inventoryManagement.addProductstoInventory(p2);

        //Check product Availibilty
        System.out.println(inventoryManagement.checkProductAvailibity(p1,50));
        System.out.println(inventoryManagement.checkProductAvailibity(p2,5));

        //create cart
        ShoppingCart shoppingCart=new ShoppingCart();
        shoppingCart.addItem(p1,10);

        Map<Product,Integer> cartSummary = shoppingCart.getCartSummary();
        for(Map.Entry<Product,Integer> entry:cartSummary.entrySet()){
            System.out.println("Product ID"+entry.getKey()+",Quantity"+entry.getValue());
        }


    }
}
