package bai37;

public class Player {
    private int number;
    private float x;
    private float y;
    private float z = 0.0f; // Mặc định là 0.0f

    // Constructor
    public Player(int number, float x, float y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    // Phương thức di chuyển trên mặt phẳng (x, y)
    public void move(float xDisp, float yDisp) {
        this.x += xDisp;
        this.y += yDisp;
    }

    // Phương thức nhảy thay đổi tọa độ z
    public void jump(float zDisp) {
        this.z += zDisp;
    }

    // Kiểm tra khoảng cách với bóng (trả về true nếu < 8)
    public boolean near(Ball ball) {
        float dx = this.x - ball.getX();
        float dy = this.y - ball.getY();
        float dz = this.z - ball.getZ();
        double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
        return distance < 8;
    }

    // Đá bóng (thay đổi vị trí bóng)
    public void kick(Ball ball) {
        if (near(ball)) {
            ball.setXYZ(ball.getX() + 5, ball.getY() + 5, ball.getZ()); // Giả sử đá bóng đi xa (5,5)
            System.out.println("Player " + number + " kicked the ball!");
        } else {
            System.out.println("Player " + number + " is too far to kick the ball.");
        }
    }

}
