package com.peng.lazysingleton;

import java.io.Serializable;

//这种形式兼顾饿汉式的内存浪费，也兼顾 synchronized 性能问题
//完美地屏蔽了这两个缺点
public class SingletonLazyInner implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SingletonLazyInner() {
		//如果单例已经实例化了，则抛出异常不让你再次实例化
		if(SingletonInner.singletonLazyInner != null) {
			throw new RuntimeException("单例类不允许实例化多次");
		}
	};
	
	//static 是为了使单例的空间共享
	//final 保证这个方法不会被重写，重载
	public static final SingletonLazyInner newInstance(){
		//在返回结果以前，一定会先加载内部类
		return SingletonInner.singletonLazyInner;
	}
	
	public Object readResolve() {
		return SingletonInner.singletonLazyInner;
	}
	
	//默认不加载
	private static class SingletonInner{
		 static final SingletonLazyInner singletonLazyInner = new SingletonLazyInner();
	}
}
