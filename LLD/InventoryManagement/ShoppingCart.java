package LLD.InventoryManagement;

import java.util.HashMap;
import java.util.Map;

class ShoppingCart {
    Map<Product, Integer> items;

    public ShoppingCart() {
        items=new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        items.put(product, quantity);
    }

    public void removeItem(Product product, int quantity) {
        int currentQuantity = items.getOrDefault(product, 0);
        int newQuantity = currentQuantity - quantity;
        if (newQuantity <= 0)
            items.remove(product);
        else
            items.put(product, newQuantity);
    }

    public Map<Product, Integer> getCartSummary() {
        return items;
    }

    public double calculateCartPrice(Map<Product, Integer> items) {
        double totalPrice = 0.0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            int quantity = entry.getValue();
            double price = entry.getKey().getPrice();
            totalPrice += quantity * price;
        }
        return totalPrice;
    }

}
