package ir.javacup.toyfactory;

public class Car extends Toy{
    public Car(double basePrice, ToySize size) {
        super(basePrice, size);
    }

    @Override
    public double getPrice() {
        double price = 0;
        switch (size) {
            case SMALL:
                price = 2 * getBasePrice();
                break;
            case MEDIUM:
                price = 2.5 * getBasePrice();
                break;
                default:
                    price = 3 * getBasePrice();

        }

        return price;
    }
}
