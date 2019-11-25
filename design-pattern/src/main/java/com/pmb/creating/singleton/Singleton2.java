package com.pmb.creating.singleton;

/**
 * 懒汉式单例模式
 * @author winterfell
 *
 */
public class Singleton2 {
    
    /**
     * 初始化的时候为空，不会占用内存，只有真正使用的时候才会创建
     */
    private static Singleton2 instance = null;
    
    private Singleton2(){
        
    }
    
    public static Singleton2 getInstance(){
        if(null == instance){
            instance =new Singleton2();
        }
        return instance;
    }
}
