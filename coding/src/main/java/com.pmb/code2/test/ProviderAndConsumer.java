package com.pmb.code2.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvrui
 */
public class ProviderAndConsumer {
    private List<Double> list = new ArrayList<>();
    private int max = 10;
    private ReentrantLock lock = new ReentrantLock();
    Condition whenFull = lock.newCondition();
    Condition whenEmpyt = lock.newCondition();
    private BlockingQueue<Double> queue = new LinkedBlockingDeque<>();

    class Provider implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    queue.offer(0d);
                    if (list.size() >= max) {
                        whenFull.await();
                    } else {
                        list.add(0d);
                        whenFull.signalAll();
                        whenEmpyt.signalAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (list.size() == 0) {
                        whenEmpyt.await();
                    } else {
                        list.remove(0);
                        whenFull.signalAll();
                        whenEmpyt.signalAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
