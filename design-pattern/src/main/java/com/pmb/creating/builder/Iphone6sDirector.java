package com.pmb.creating.builder;

public class Iphone6sDirector implements IphoneDirector{

	IphoneBuilder iphoneBuilder;
	
	public Iphone6sDirector(IphoneBuilder iphoneBuilder) {
		this.iphoneBuilder = iphoneBuilder;
	}

	@Override
	public Iphone directIphone() {
		Motherboard motherboard = iphoneBuilder.buildMotherboard();
		Battery battery = iphoneBuilder.buildBattery();
		Display display = iphoneBuilder.buildDisplay();
		Iphone iphone = new Iphone();
		iphone.setMotherboard(motherboard);
		iphone.setBattery(battery);
		iphone.setDisplay(display);
		return iphone;
	}
	
}
