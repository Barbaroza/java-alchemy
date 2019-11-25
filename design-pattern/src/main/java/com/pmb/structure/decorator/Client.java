package com.pmb.structure.decorator;

public class Client {
	public static void main(String[] args) {
		ICar car = new Car();
		ICar supperCar = new FlyCar(car);
		supperCar.move();
	}
}
