package bai1;

public class Circle1 {
    private double radius = 1.0;
    private String color = "red";

    public Circle1() {
    }

    public Circle1(double r) {
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle1{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }

    public double getArea() {
        return Math.PI*radius*radius;
    }
    public double getCircumference(){
        return Math.PI*2*radius;
    }
    public static void main(String[] args) {
        Circle1 c1 = new Circle1();
        Circle1 c2 = new Circle1(6.0);
        Circle1 c3 = new Circle1(6.5);

        System.out.println("Bán kính c1: " + c1.getRadius());
        System.out.println("Diện tích c1: " + c1.getArea());

        System.out.println("Bán kính c2: " + c2.getRadius());
        System.out.println("Diện tích c2: " + c2.getArea());
        System.out.println("Bán kính c3: " + c3.getRadius());
        System.out.println("Diện tích c3: " + c3.getArea());
    }

}