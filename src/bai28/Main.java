package bai28;

public class Main {
    public static void main(String[] args) {
        MyCircle circle1 = new MyCircle(3, 4, 5);
        MyCircle circle2 = new MyCircle(7, 1, 3);

        System.out.println(circle1);
        System.out.println("Area: " + circle1.getArea());
        System.out.println("Circumference: " + circle1.getCircumference());
        System.out.println("Distance to another circle: " + circle1.distance(circle2));
    }

}
