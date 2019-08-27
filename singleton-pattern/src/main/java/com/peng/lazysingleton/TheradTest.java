package com.peng.lazysingleton;

//实现Runnable接口
public class TheradTest implements Runnable{

	//重写其run方法
	@Override
	public void run() {
		//调用单例的全局访问点
		SingletonLazy newInstance = SingletonLazy.newInstance();
		//打印该类的内存地址信息等
		System.out.println(newInstance);
	}
}
