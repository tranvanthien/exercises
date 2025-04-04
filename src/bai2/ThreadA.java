package bai2;

public class ThreadA extends Thread {
    public void run() {
        while (true) {
            if (SharedResource.resource1.tryLock()) {
                try {
                    System.out.println("Thread A locked resource 1");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {}

                    if (SharedResource.resource2.tryLock()) {
                        try {
                            System.out.println("Thread A locked resource 2");
                            System.out.println("Thread A is processing...");
                            break;
                        } finally {
                            SharedResource.resource2.unlock();
                        }
                    }
                } finally {
                    SharedResource.resource1.unlock();
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }
    }
}
