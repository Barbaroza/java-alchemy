package com.pmb.creating.factory.factorymethod;

public class Client {
    
    public static void main(String[] args) {
        
        Car audi = new AudiCarFactory().createCar();
        Car byd = new BydCarFactory().createCar();
        
        audi.run();
        byd.run();
    }
}
