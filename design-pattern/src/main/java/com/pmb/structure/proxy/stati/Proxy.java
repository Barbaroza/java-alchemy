package com.pmb.structure.proxy.stati;

public class Proxy implements Action {
	private Real real;
	public Proxy(Real real) {
		this.real = real;
	}
	@Override
	public void func1() {
		System.out.println("Proxy.func1()");
	}

	@Override
	public void func2() {
		System.out.println("Proxy.func2()");
	}

	@Override
	public void action() {
		real.action();
	}

	@Override
	public void func3() {
		System.out.println("Proxy.func3()");
	}
}
