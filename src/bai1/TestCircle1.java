package bai1;

public class TestCircle1 {
    public static void main(String[] args) {
        Circle1 c1 = new Circle1(1.1);
        System.out.println(c1);
        Circle1 c2 = new Circle1();
        System.out.println(c2);
        c1.setRadius(2.2);
        System.out.println(c1);
        System.out.println("Radius: " + c1.getRadius());
        System.out.println("Area is: " + c1.getArea());
        System.out.println("Circumference is: " + c1.getCircumference());
    }
}