package bai26;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(); // Điểm (0,0)
        Point p2 = new Point(3, 4); // Điểm (3,4)

        System.out.println("Point 1: " + p1); // (0,0)
        System.out.println("Point 2: " + p2); // (3,4)

        System.out.println("Distance from p1 to (3,4): " + p1.distance(3, 4)); // 5.0
        System.out.println("Distance from p1 to p2: " + p1.distance(p2)); // 5.0
        System.out.println("Distance from p2 to origin: " + p2.distance()); // 5.0
    }

}
