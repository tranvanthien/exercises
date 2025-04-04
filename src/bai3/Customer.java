package bai3;
import java.util.concurrent.BlockingQueue;

public class Customer extends Thread {
    private final BlockingQueue<String> customerQueue;
    private final String name;

    public Customer(BlockingQueue<String> customerQueue, String name) {
        this.customerQueue = customerQueue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                String bread = customerQueue.take();
                System.out.println(name + " Mua: " + bread);
                Thread.sleep(700);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " không thể mua thêm bất kỳ bánh mì nào nữa.");
        }
    }

}
