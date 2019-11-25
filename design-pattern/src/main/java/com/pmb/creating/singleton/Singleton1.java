package com.pmb.creating.singleton;

/**
 * 饿汉式单例模式
 * @author winterfell
 *
 */
public class Singleton1 {
    
    /**
     * 在类初始化的时候直接创建
     */
    private static Singleton1 instance = new Singleton1();
    
    /**
     * 私有的构造器，不让外部进行new的操作
     */
    private Singleton1(){
        
    }
    
    /**
     * 获取单例对象
     * @return
     */
    public static Singleton1 getInstance(){
        if(null == instance ){
            instance = new Singleton1();
        }
        return instance;
    }
    
}
