package ir.javacup.shop;

public class WinterDiscountStrategy implements DiscountStrategy{
    @Override
    public long priceByDiscount(Clothing clothing) {
        long finalPrice = clothing.getBasePrice();
        long discount;
        switch (clothing.getSeason()) {
            case FALL:
                discount = finalPrice * 40;
                discount /= 100;
                finalPrice -= discount;
                break;
            case WINTER:
                discount = finalPrice * 50;
                discount /= 100;
                finalPrice -= discount;
                break;
            case SUMMER:
                discount = finalPrice * 25;
                discount /= 100;
                finalPrice -= discount;
                break;
        }

        if (clothing instanceof Jacket) {
            discount = finalPrice * 10;
            discount /= 100;
            finalPrice -= discount;
        }

        return finalPrice;
    }
}
