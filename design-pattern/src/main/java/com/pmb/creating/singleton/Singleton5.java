package com.pmb.creating.singleton;

/**
 * 1.5 后使用 注意关键字 volatile
 * *1.给instance分配内存
 * *
 * * 2.调用Singleton构造完成初始化
 * *
 * * 3.使instance对象的引用指向分配的内存空间(完成这一步instance就不是null了)
 *
 * @author lvrui
 */
public class Singleton5 {
    private Singleton5() {
    }

    private static volatile Singleton5 instance = null;

    public static Singleton5 getInstance() {
        if (null == instance) {
            synchronized (Singleton5.class) {
                if (null == instance) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }

}
