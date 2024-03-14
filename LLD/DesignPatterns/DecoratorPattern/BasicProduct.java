package LLD.DesignPatterns.DecoratorPattern;

import java.util.UUID;

public class BasicProduct implements Product {
    UUID productId;
    String productName;
    int price;
    ProductType productType;

    public  BasicProduct(String productName, int price, ProductType productType) {
        this.productName = productName;
        this.price = price;
        this.productType = productType;
        this.productId=UUID.randomUUID();
    }

    @Override
    public double getPrice() {
        return price;
    }
}
