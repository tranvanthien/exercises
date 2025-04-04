package bai51Line;
import java.awt.Point;

public class Line {
    // A line is defined by two points
    private Point begin;
    private Point end;

    // Constructors
    public Line(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }

    public Line(int beginX, int beginY, int endX, int endY) {
        this.begin = new Point(beginX, beginY);
        this.end = new Point(endX, endY);
    }

    // toString method
    @Override
    public String toString() {
        return "Line[begin=" + begin + ", end=" + end + "]";
    }

    // Getters and Setters
    public Point getBegin() { return begin; }
    public Point getEnd() { return end; }

    public void setBegin(Point begin) { this.begin = begin; }
    public void setEnd(Point end) { this.end = end; }

    public int getBeginX() { return begin.x; }
    public int getBeginY() { return begin.y; }
    public int getEndX() { return end.x; }
    public int getEndY() { return end.y; }

    public void setBeginX(int x) { begin.x = x; }
    public void setBeginY(int y) { begin.y = y; }
    public void setBeginXY(int x, int y) { begin.setLocation(x, y); }
    public void setEndX(int x) { end.x = x; }
    public void setEndY(int y) { end.y = y; }
    public void setEndXY(int x, int y) { end.setLocation(x, y); }

    // Calculate the length of the line using the distance formula
    public double getLength() {
        int xDiff = end.x - begin.x;
        int yDiff = end.y - begin.y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    // Calculate the gradient (angle in radians)
    public double getGradient() {
        int xDiff = end.x - begin.x;
        int yDiff = end.y - begin.y;
        return Math.atan2(yDiff, xDiff);
    }
}