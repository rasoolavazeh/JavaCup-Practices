package ir.javacup.company;

public class Company {
    private final String name;

    private Company () {
        this.name = "JavaCup.co";
    }
    private static Company instance = new Company();

    public String getName() {
        return name;
    }

    public static Company getInstance() {
        return instance;
    }

}
