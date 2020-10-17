package ir.javacup.shop;

public class YaldaDiscountStrategy implements DiscountStrategy{
    @Override
    public long priceByDiscount(Clothing clothing) {
        long finalPrice = clothing.getBasePrice();
        long discount;
        if (clothing instanceof Jacket) {
            discount = finalPrice * 10;
            discount /= 100;
            finalPrice -= discount;
        } else if (clothing instanceof Socks) {
            discount = finalPrice * 20;
            discount /= 100;
            finalPrice -= discount;
        } else {
            discount = finalPrice * 25;
            discount /= 100;
            finalPrice -= discount;
        }

        return finalPrice;
    }
}
