package bai2;

public class ThreadB extends Thread {
    public void run() {
        while (true) {
            if (SharedResource.resource2.tryLock()) {
                try {
                    System.out.println("Thread B locked resource 2");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {}

                    if (SharedResource.resource1.tryLock()) {
                        try {
                            System.out.println("Thread B locked resource 1");
                            System.out.println("Thread B is processing...");
                            break;
                        } finally {
                            SharedResource.resource1.unlock();
                        }
                    }
                } finally {
                    SharedResource.resource2.unlock();
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }
    }
}
