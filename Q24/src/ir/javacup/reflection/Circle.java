package ir.javacup.reflection;

public class Circle {
    public Double radius;
    public int a;
    private String b;
    public Circle() {}
    public Circle(Double radius, int a, String b) {
        this.radius = radius;
        this.a = a;
        this.b = b;
    }
    public Double getRadius() {
        return radius;
    }
    public void setRadius(Double radius) {
        this.radius = radius;
    }
    public double area(){
        return Math.PI*Math.pow(radius, 2);
    }
    public double perimeter(){
        return Math.PI*2*radius;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getB() {
        return b;
    }
}
