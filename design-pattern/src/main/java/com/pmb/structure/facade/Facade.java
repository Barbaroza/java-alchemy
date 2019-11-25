package com.pmb.structure.facade;

public class Facade {
	private SubSystem1 system1;
	private SubSystem2 system2;
	private SubSystem3 system3;
	private SubSystem4 system4;

	public Facade(SubSystem1 system1, SubSystem2 system2, SubSystem3 system3,
			SubSystem4 system4) {
		super();
		this.system1 = system1;
		this.system2 = system2;
		this.system3 = system3;
		this.system4 = system4;
	}

	public void doSth1() {
		system1.subFunc1();
		system2.subFunc2();
	}

	public void doSth2() {
		doSth1();
		system3.subFunc3();
		system4.subFunc4();
	}

}
