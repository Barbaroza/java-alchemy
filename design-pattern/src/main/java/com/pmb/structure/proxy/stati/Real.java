package com.pmb.structure.proxy.stati;

public class Real implements Action{

	@Override
	public void func1() {
		System.out.println("Real.func1()");
	}

	@Override
	public void func2() {
		System.out.println("Real.func2()");
	}

	@Override
	public void action() {
		System.out.println("Real.action()");
	}

	@Override
	public void func3() {
		System.out.println("Real.func3()");
	}

}
