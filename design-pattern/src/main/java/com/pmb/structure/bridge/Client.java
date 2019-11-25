package com.pmb.structure.bridge;

/**
 * @author winterfell
 *
 */
public class Client {
	public static void main(String[] args) {
		// 销售联想台式机
		Computer c = new Desktop(new Lenovo());
		c.sale();
		
		// 销售联想笔记本
		Computer c2 = new Laptop(new Lenovo());
		c2.sale();
		
		// 销售dell笔记本
		Computer c3 = new Laptop(new Dell());
		c3.sale();
	}
}
