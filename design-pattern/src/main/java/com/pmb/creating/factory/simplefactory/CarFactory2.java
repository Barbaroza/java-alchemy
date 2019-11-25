package com.pmb.creating.factory.simplefactory;

public class CarFactory2 {
    public static Car createByd(){
        return new Byd();
    }
    public static Car createAudi(){
        return new Audi();
    }
}
