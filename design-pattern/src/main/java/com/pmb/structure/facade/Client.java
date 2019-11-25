package com.pmb.structure.facade;

public class Client {
	public static Facade f = new Facade(new SubSystem1(), new SubSystem2(), new SubSystem3(), new SubSystem4());
	public static void main(String[] args) {
		System.out.println("做某一件事要用到子系统1、2");
		f.doSth1();
		System.out.println("做某一件事要用到子系统1、2、3、4");
		f.doSth2();
	}
}
