package com.pmb.creating.singleton;

/**
 * 静态内部类实现单例模式
 * @author winterfell
 *
 */
public class Singleton3 {
    
    /**
     * 注意这是一个静态内部类 
     */
    private static class SingletonClassInstace{
        /**
         * 在这里创建单例
         * 用final修饰保证唯一
         * @return
         */
        public static final Singleton3 INSTANCE = new Singleton3();
    }
    
    /**
     * 获得单例
     * @return
     */
    public static Singleton3 getInstance(){
       return SingletonClassInstace.INSTANCE;
    }
}
