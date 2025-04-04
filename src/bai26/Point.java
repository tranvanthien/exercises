package bai26;

public class Point {
    private int x = 0;
    private int y = 0;


    public Point() {
    }

    // Constructor có tham số
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter & Setter
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY() {
        return new int[]{x, y};
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Phương thức toString()
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    // Tính khoảng cách đến một điểm (x, y)
    public double distance(int x, int y) {
        int dx = this.x - x;
        int dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Tính khoảng cách đến một điểm MyPoint khác
    public double distance(Point another) {
        int dx = this.x - another.x;
        int dy = this.y - another.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Tính khoảng cách đến gốc tọa độ (0,0)
    public double distance() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

}