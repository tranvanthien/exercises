package bai51Linesub;
import java.awt.Point;
public class TestLineSub {
    public static void main(String[] args) {

        LineSub line1 = new LineSub(1, 2, 4, 6);


        Point begin = new Point(2, 3);
        Point end = new Point(5, 7);
        LineSub line2 = new LineSub(begin, end);
        System.out.println("Line 1: " + line1.toString());
        System.out.println("Line 2: " + line2.toString());
        System.out.println("Line 1 Length: " + line1.getLength());
        System.out.println("Line 1 Gradient: " + line1.getGradient());
        System.out.println("Line 2 Length: " + line2.getLength());
        System.out.println("Line 2 Gradient: " + line2.getGradient());
        line1.setEndXY(7, 8);
        System.out.println("Modified Line 1: " + line1.toString());
        System.out.println("Modified Line 1 Length: " + line1.getLength());
    }
}
