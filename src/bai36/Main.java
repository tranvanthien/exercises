package bai36;

public class Main {
    public static void main(String[] args) {
        MyBall ball = new MyBall(50, 50, 10, 5, 7);
        Container container = new Container(0, 0, 100, 100);

        System.out.println(ball);
        for (int i = 0; i < 10; i++) {
            ball.move();
            if (container.collides(ball)) {
                ball.reflectHorizontal();
                ball.reflectVertical();
            }
            System.out.println(ball);
        }
    }

}
