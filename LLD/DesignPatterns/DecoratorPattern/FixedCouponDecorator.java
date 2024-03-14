package LLD.DesignPatterns.DecoratorPattern;

public class FixedCouponDecorator extends CouponDecorator {
    Product product; //decorator has a product

    public FixedCouponDecorator(Product product) {
        super(product);
        System.out.println("I am FixedCouponDecorator");
    }
    @Override
    public double getPrice() {
        // Apply fixed coupon discount
        double fixedCouponPrice=super.getPrice() - 10;
        System.out.println("fixedCouponPrice"+fixedCouponPrice);
        return  fixedCouponPrice;// Assuming a fixed discount of 10
    }

}
