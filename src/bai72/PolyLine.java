package bai72;

import java.util.*;

public class PolyLine {
    private List<Point> points; // List of Point instances

    // Default constructor
    public PolyLine() {
        points = new ArrayList<>(); // Implement with ArrayList
    }

    // Constructor with List of Points
    public PolyLine(List<Point> points) {
        this.points = new ArrayList<>(points); // Ensures encapsulation
    }

    // Append a point (x, y) to the end of this polyline
    public void appendPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    // Append a Point instance to the end of this polyline
    public void appendPoint(Point point) {
        points.add(point);
    }

    // Return formatted string {(x1,y1)(x2,y2)(x3,y3)...}
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Point aPoint : points) {
            sb.append(aPoint.toString());
        }
        sb.append("}");
        return sb.toString();
    }
}
