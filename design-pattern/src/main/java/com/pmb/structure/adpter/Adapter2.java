package com.pmb.structure.adpter;

/**
 * 对象适配器
 * @author winterfell
 *
 */
public class Adapter2 implements Target {
	
	private Adaptee adaptee;
	
	public Adapter2(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	@Override
	public void handleReq() {
		adaptee.request();
	}
	
}
