package LLD.DesignPatterns.DecoratorPattern;

public class CouponDecorator implements Product {//Coupon Decorator is a Product
    Product couponDecoratedProduct;

    public CouponDecorator(Product couponDecoratedProduct) {
        this.couponDecoratedProduct = couponDecoratedProduct;
    }

    @Override
    public double getPrice() {
        return couponDecoratedProduct.getPrice();
    }
}
