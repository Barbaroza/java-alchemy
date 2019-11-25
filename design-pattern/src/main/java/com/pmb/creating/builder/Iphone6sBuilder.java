package com.pmb.creating.builder;

public class Iphone6sBuilder implements IphoneBuilder {

	@Override
	public Motherboard buildMotherboard() {
		System.out.println("构造6s主板");
		return new Motherboard("6s主板");
	}

	@Override
	public Battery buildBattery() {
		System.out.println("构造6s电池");
		return new Battery("6s电池");
	}

	@Override
	public Display buildDisplay() {
		System.out.println("构造6s显示器");
		return new Display("6s显示器");
	}
	
}
