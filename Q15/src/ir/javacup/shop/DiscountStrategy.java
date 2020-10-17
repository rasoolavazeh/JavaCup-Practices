package ir.javacup.shop;

public interface DiscountStrategy {
    long priceByDiscount(Clothing clothing);
}
