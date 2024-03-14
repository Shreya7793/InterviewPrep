package LLD.InventoryManagement;

import java.util.UUID;

class Product {
    UUID productId;
    String productName;
    String description;
    double price;
    int availableUnits;

    public Product(UUID productId, String productName, String description, double price, int availableUnits) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.availableUnits = availableUnits;
    }

    public double getPrice() {
        return price;
    }

    public UUID getProductId() {
        return productId;
    }

    public int getAvailableUnits() {
        return availableUnits;
    }
    //Getters & Setters
}
