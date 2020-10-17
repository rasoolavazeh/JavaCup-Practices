package ir.javacup.shop;

public class SummerDiscountStrategy implements DiscountStrategy{
    @Override
    public long priceByDiscount(Clothing clothing) {
        long finalPrice = clothing.getBasePrice();
        long discount;
        switch (clothing.getSeason()) {
            case SPRING:
                discount = finalPrice * 40;
                discount /= 100;
                finalPrice -= discount;
                break;
            case SUMMER:
                discount = finalPrice * 50;
                discount /= 100;
                finalPrice -= discount;
                break;
            case WINTER:
                discount = finalPrice * 30;
                discount /= 100;
                finalPrice -= discount;
                break;
        }

        return finalPrice;
    }
}
