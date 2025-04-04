package bai27;

public class Main {
    public static void main(String[] args) {
        Line line = new Line(1, 2, 3, 4);
        System.out.println(line);
        System.out.println("Length: " + line.getLength());
        System.out.println("Gradient: " + line.getGradient());
    }
}
