package com.peng.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	
	
	public Object newInstance(Object object) {
		Enhancer enhancer = new Enhancer();
		//要把哪个设置为即将生成的代理类的父类
		enhancer.setSuperclass(object.getClass());
		//设置需要代理调用的类,相当于JDK的声明invocationHandler的实现类
		enhancer.setCallback(this);
		
		return enhancer.create();
	}
	
	//相当于 jdk的invoke方法
	@Override
	public Object intercept(Object o, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
		System.out.println("骑手小哥接单");
		Object invokeSuper = methodProxy.invokeSuper(o, arg);
		System.out.println("骑手小哥取货后送单");
		return invokeSuper;
	}

}
