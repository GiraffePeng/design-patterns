package com.peng.threadlocal;

public class ThreadLocalSingleton {

	private static ThreadLocal<ThreadLocalSingleton> threadLocal = new ThreadLocal<ThreadLocalSingleton>() {
		//重写其的初始化方法，将实例化的ThreadLocalSingleton放入到threadLocal中
		@Override
		protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
	};
	
	private ThreadLocalSingleton() {};
	
	public static ThreadLocalSingleton getInstance() {
		return threadLocal.get();
	}
}
