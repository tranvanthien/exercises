package bai62;

public class Main {
    public static void main(String[] args) {
        GeometricObject circle = new Circle(5.0);
        System.out.println(circle);
        System.out.println(" Area: " + circle.getArea());
        System.out.println(" Perimeter: " + circle.getPerimeter());

        GeometricObject rectangle = new Rectangle(4.0, 6.0);
        System.out.println(rectangle);
        System.out.println(" Area: " + rectangle.getArea());
        System.out.println(" Perimeter: " + rectangle.getPerimeter());
    }
}
