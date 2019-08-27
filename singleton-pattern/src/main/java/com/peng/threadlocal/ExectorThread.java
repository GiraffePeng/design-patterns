package com.peng.threadlocal;

public class ExectorThread implements Runnable{

	@Override
	public void run() {
		ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
		System.out.println(Thread.currentThread().getName()+instance);
		System.out.println(Thread.currentThread().getName()+ThreadLocalSingleton.getInstance());
		System.out.println(Thread.currentThread().getName()+ThreadLocalSingleton.getInstance());
		System.out.println(Thread.currentThread().getName()+ThreadLocalSingleton.getInstance());
		System.out.println(Thread.currentThread().getName()+ThreadLocalSingleton.getInstance());
		System.out.println(Thread.currentThread().getName()+ThreadLocalSingleton.getInstance());
		System.out.println(Thread.currentThread().getName()+ThreadLocalSingleton.getInstance());
		System.out.println(Thread.currentThread().getName()+ThreadLocalSingleton.getInstance());
		System.out.println(Thread.currentThread().getName()+ThreadLocalSingleton.getInstance());
	}

}
