package LLD.DesignPatterns.DecoratorPattern;

public class PercentageCouponDecorator extends CouponDecorator {

    Product product;

    public PercentageCouponDecorator(Product product) {
        super(product);
        System.out.println("I am PercentageCouponDecorator");

    }
    @Override
    public double getPrice() {
        // Apply perecntage coupon discount
        double percentageCouponPrice=super.getPrice() - 0.90;
        System.out.println("percentageCouponPrice"+percentageCouponPrice);
        return percentageCouponPrice; //10% discount
    }
}
