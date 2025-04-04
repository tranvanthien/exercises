package bai29;

public class Main {
    public static void main(String[] args) {
        MyTriangle triangle = new MyTriangle(0, 0, 3, 0, 0, 4);
        System.out.println(triangle);
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Type: " + triangle.getType());
    }

}
