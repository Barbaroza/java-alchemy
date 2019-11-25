package com.pmb.creating.factory.factorymethod;

public class BydCarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new Byd();
    }

}
