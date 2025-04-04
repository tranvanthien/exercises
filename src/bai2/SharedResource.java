package bai2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

 public class SharedResource {
    static final Lock resource1 = new ReentrantLock();
    static final Lock resource2 = new ReentrantLock();
}

