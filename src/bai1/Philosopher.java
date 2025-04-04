package bai1;

public class Philosopher extends Thread {
    private final int id;
    private final Chopstick leftChopstick, rightChopstick;
    private static int totalMeals = 5;
    private static final Object mealLock = new Object(); 

    public Philosopher(int id, Chopstick left, Chopstick right) {
        this.id = id;
        this.leftChopstick = left;
        this.rightChopstick = right;
    }

    @Override
    public void run() {
        while (true) {
            think();

            if (leftChopstick.pickUp()) {
                if (rightChopstick.pickUp()) {
                    synchronized (mealLock) {
                        if (totalMeals > 0) {
                            eat();
                            totalMeals--;
                            if (totalMeals == 0) {
                                System.out.println("Hết đồ ăn! Kết thúc bữa ăn.");
                                System.exit(0); // Thoát chương trình khi hết đồ ăn
                            }
                        }
                    }
                    rightChopstick.putDown();
                }
                leftChopstick.putDown();
            }
        }
    }

    private void think() {
        System.out.println("Người " + id + " đang nhìn người khác ăn...");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        System.out.println("Người " + id + " đang ăn. Còn " + totalMeals + " suất.");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
