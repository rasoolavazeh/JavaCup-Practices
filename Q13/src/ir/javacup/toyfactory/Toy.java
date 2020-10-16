package ir.javacup.toyfactory;

public class Toy {
    private double basePrice;
    protected ToySize size;

    public Toy(double basePrice, ToySize size) {
        this.basePrice = basePrice;
        this.size = size;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getPrice() {
        double price;
        switch (size) {
            case SMALL:
                price = basePrice;
                break;
            case MEDIUM:
                price = 1.5 * basePrice;
                break;
                default:
                    price = 2 * basePrice;
        }

        return price;
    }

    public double getPrice(double discount) {
        double tmp = discount / 100;
        tmp *= getPrice();

        return getPrice() - tmp;
    }

//    public static void main(String[] args) {
//        Car car = new Car(20000, ToySize.SMALL);
//        System.out.println(car.getPrice());
//        System.out.println(car.getPrice(20));
//    }
}
