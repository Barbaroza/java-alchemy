package com.pmb.creating.factory.abstractFactory;

public class LowCarFactory implements CarFactory {

	@Override
	public Engine createEngine() {
		return new LowEngine();
	}

	@Override
	public Seat createSeat() {
		return new LowSeat();
	}

	@Override
	public Tyre createTyre() {
		return new LowTyre();
	}


}
