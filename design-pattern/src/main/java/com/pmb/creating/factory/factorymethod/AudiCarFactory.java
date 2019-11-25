package com.pmb.creating.factory.factorymethod;

public class AudiCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Audi();
    }
}
