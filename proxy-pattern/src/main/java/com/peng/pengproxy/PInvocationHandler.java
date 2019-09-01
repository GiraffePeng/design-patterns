package com.peng.pengproxy;

import java.lang.reflect.Method;

//相当于jdk的invocationHandler
public interface PInvocationHandler {
	public Object invoke(Object proxy, Method method, Object[] args)
	        throws Throwable;
}
