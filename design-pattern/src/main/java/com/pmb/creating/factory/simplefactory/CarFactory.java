package com.pmb.creating.factory.simplefactory;

/**
 * 假单工厂方法
 * 创建不同car的工厂
 * @author winterfell
 *
 */
public class CarFactory {
    
    public static Car createCar(String carName){
        if("奥迪".equals(carName)){
            return new Audi();
        }else if("比亚迪".equals(carName)){
            return new Byd();
        }else{
            return null;
        }
    }
}
