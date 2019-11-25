package com.pmb.structure.bridge;

/**
 * 维度1 电脑品牌维度
 * @author winterfell
 *
 */
public interface Brand {
	
	void sale();
}

class Lenovo implements Brand {
	@Override
	public void sale() {
		System.out.println("销售联想电脑");
	}
}

class Dell implements Brand {
	@Override
	public void sale() {
		System.out.println("销售Dell电脑");
	}
}