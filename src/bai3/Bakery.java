package bai3;
import java.util.concurrent.BlockingQueue;

public class Bakery  extends Thread{
    private final BlockingQueue<String> storeQueue;

    public Bakery(BlockingQueue<String> storeQueue) {
        this.storeQueue = storeQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                String bread = "Bánh mì " + i;
                System.out.println("Sản xuất bánh: " + bread);
                storeQueue.put(bread);
                Thread.sleep(500);
            }
            System.out.println("Tiệm bánh đã sản xuất xong.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
