package com.peng.threadlocal;

public class TestThreadLocal {
	public static void main(String[] args) {
		System.out.println(ThreadLocalSingleton.getInstance());
		System.out.println(ThreadLocalSingleton.getInstance());
		System.out.println(ThreadLocalSingleton.getInstance());
		System.out.println(ThreadLocalSingleton.getInstance());
		System.out.println(ThreadLocalSingleton.getInstance());
		Thread t1 = new Thread(new ExectorThread());
		Thread t2 = new Thread(new ExectorThread());
		t1.start();
		t2.start();
	}
}
