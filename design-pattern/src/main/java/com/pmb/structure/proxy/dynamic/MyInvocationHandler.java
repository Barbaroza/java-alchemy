package com.pmb.structure.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler<T> implements InvocationHandler {

	private T t;

	public MyInvocationHandler(T t) {
		this.t = t;
	}

	public T getProxy() {
		return (T)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), t
				.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object object = null;
		if(method.getName().equals("action")){
			object = method.invoke(t, args);
		}
		return object;
	}

}
