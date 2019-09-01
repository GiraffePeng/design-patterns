package com.peng.datasoruce.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.peng.datasoruce.datasource.DataSource;
import com.peng.datasoruce.entity.Order;

public class OrderDaoJdkProxy implements InvocationHandler{
	
	private Object object;
	
	public Object newProxyInstance(Object object) {
		this.object = object;
		Class<? extends Object> clazz = object.getClass();
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object arg = args[0];
		Integer id = (Integer)arg.getClass().getMethod("getId").invoke(arg);
		if(id % 2 == 0) {
			//订单的主键为偶数，则使用偶数数据源
			DataSource.set(DataSource.EVENNUMBERS);
		}else{
			//为奇数，使用奇数数据源
			DataSource.set(DataSource.SINGULAR);
		}
		Object invoke = method.invoke(object, args);
		DataSource.reset();
		return invoke;
	}
}
