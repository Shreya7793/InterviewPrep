package LLD.InventoryManagement;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InventoryManagement {
   static InventoryManagement inventoryManagement;
   Map <UUID,Product> products; //Product id-product Map - Inventory management has info about the products
   Map <UUID, Order> orders;
   Map<UUID,Customer> customers;

    private InventoryManagement() {
        products=new HashMap<>();
        orders=new HashMap<>();
        customers=new HashMap<>();
    }

    public static InventoryManagement getInstance(){
        if(inventoryManagement==null){
            synchronized (InventoryManagement.class){
                if(inventoryManagement==null)
                    inventoryManagement=new InventoryManagement();
            }
        }
        return inventoryManagement;
    }

    public String checkProductAvailibity(Product product, int quantity){
       if(products.get(product.getProductId()).getAvailableUnits()>quantity)
           return "Product is not available";
        return "Product available";
    }
    public double applyDiscount(Product product){
        //Discount Strategy
        return product.getPrice()*0.9;
    }
    void addProductstoInventory(Product product){
        products.put(product.getProductId(),product);
    }
}

