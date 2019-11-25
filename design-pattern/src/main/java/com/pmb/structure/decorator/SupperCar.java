package com.pmb.structure.decorator;

public class SupperCar implements ICar{
	private ICar car;
	@Override
	public void move() {
		car.move();
	}
	public SupperCar(ICar car) {
		this.car = car;
	}
}

class FlyCar extends SupperCar {
	public FlyCar(ICar car) {
		super(car);
	}
	
	public void fly(){
		System.out.println("天上飞！！！");
	}

	@Override
	public void move() {
		super.move();
		fly();
	}
}

class WaterCar extends SupperCar {
	public WaterCar(ICar car) {
		super(car);
	}
	
	public void swim(){
		System.out.println("水里游！！！");
	}

	@Override
	public void move() {
		super.move();
		swim();
	}
}
