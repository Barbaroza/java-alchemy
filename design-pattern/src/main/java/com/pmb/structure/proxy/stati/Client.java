package com.pmb.structure.proxy.stati;

public class Client {
	public static void main(String[] args) {
		Real real = new Real();
		Proxy proxy = new Proxy(real);
		proxy.func1();
		proxy.func2();
		proxy.action();
		proxy.func3();
	}
}
