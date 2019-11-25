package com.pmb.action.Mediator;

/**
 * 中介者
 * @author winterfell
 *
 */
public interface Mediator {
	
	void register(String dname, Department d);
	
	void command(String command);
}
