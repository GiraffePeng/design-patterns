package com.peng.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//实现JDK提供的InvocationHandler接口，并重写他的invoke方法
public class RiderProxy implements InvocationHandler{

	private Object object;
	
	public Object newProxyInstance(Object object) {
		this.object = object;
		Class<? extends Object> clazz = object.getClass();
		//使用JDK提供的方，生成代理类
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("骑手小哥接单");
		Object invoke = method.invoke(this.object, args);
		System.out.println("骑手小哥取货后送单");
		return invoke;
	}

}
