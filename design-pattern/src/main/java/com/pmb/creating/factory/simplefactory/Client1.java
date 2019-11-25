package com.pmb.creating.factory.simplefactory;

/**
 * 测试CarFactory
 * @author winterfell
 *
 */
public class Client1 {
    public static void main(String[] args) {
        Car car = CarFactory.createCar("奥迪");
        car.run();
    }
}
