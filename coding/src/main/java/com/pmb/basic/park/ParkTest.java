package com.pmb.basic.park;

import java.util.concurrent.locks.LockSupport;

/**
 * @author lvrui
 */
public class ParkTest {
    public static void main(String[] agrs) throws InterruptedException {
        Thread th = new Thread(() -> {
            //唤醒当前线程
            LockSupport.unpark(Thread.currentThread());
            //阻塞当前线程
            LockSupport.park();
            System.out.println("子线程执行---------");
        });
        th.start();
        //睡眠2秒
        Thread.sleep(2000);
        System.out.println("主线程执行---------");
    }
}


