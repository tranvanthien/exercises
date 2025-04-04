package bai45;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("blue", false, 5.0);
        System.out.println(circle);

        Rectangle rectangle = new Rectangle(4.0, 6.0, "green", true);
        System.out.println(rectangle);

        Square square = new Square(4.0, "yellow", false);
        System.out.println(square);
    }
}
