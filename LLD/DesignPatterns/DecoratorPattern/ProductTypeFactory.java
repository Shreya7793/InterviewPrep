package LLD.DesignPatterns.DecoratorPattern;

public class ProductTypeFactory {

    static Product  createProduct(ProductType productType, String productName, int price){
        switch (productType){
            case ProductType.ELECTRONIC_GOODS ->
            {
                return new BasicProduct(productName,price,ProductType.ELECTRONIC_GOODS); //use different product concrete class
            }
            case ProductType.EDIBLE_GOODS ->
            {
                return new BasicProduct(productName,price,ProductType.EDIBLE_GOODS);
            }
            default ->
                throw new IllegalArgumentException("Invalid Product type");
        }
    }
}
