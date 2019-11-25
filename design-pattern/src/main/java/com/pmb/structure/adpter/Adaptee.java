package com.pmb.structure.adpter;

/**
 * 被适配对象
 * （相当于PS/2结构的键盘）
 * @author winterfell
 *
 */
public class Adaptee {
	public void request(){
		System.out.println("打字。。。");
	}
}
