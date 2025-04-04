package bai44;

public class Main {
    public static void main(String[] args) {
        MovablePoint mp = new MovablePoint(2, 3, 1, 1);
        System.out.println(mp);
        mp.move();
        System.out.println(mp);
    }
}
