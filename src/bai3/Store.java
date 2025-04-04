package bai3;
import java.util.concurrent.BlockingQueue;

public class Store extends Thread{
    private final BlockingQueue<String> storeQueue;
    private final BlockingQueue<String> customerQueue;

    public Store(BlockingQueue<String> storeQueue, BlockingQueue<String> customerQueue) {
        this.storeQueue = storeQueue;
        this.customerQueue = customerQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String bread = storeQueue.take();
                System.out.println("Cửa hàng đã nhận: " + bread);
                customerQueue.put(bread);
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println("Cửa hàng đóng cửa.");
        }
    }
}
