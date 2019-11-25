package com.pmb.structure.decorator;

public class Car implements ICar {

	@Override
	public void move() {
		System.out.println("车子普通的跑");
	}
}
