package bai3;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class Test {
    public static void main(String[] args) {
        BlockingQueue<String> storeQueue = new LinkedBlockingQueue<>(5);
        BlockingQueue<String> customerQueue = new LinkedBlockingQueue<>(5);

        Bakery bakery = new Bakery(storeQueue);
        Store store = new Store(storeQueue, customerQueue);
        Customer customer1 = new Customer(customerQueue, "Khách Hàng 1");
        Customer customer2 = new Customer(customerQueue, "Khách Hàng 2");

        bakery.start();
        store.start();
        customer1.start();
        customer2.start();
    }
}
