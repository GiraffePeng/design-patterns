package com.peng.lazysingleton;

/**
 * 懒汉式
 */
public class SingletonLazy{

    //声明一个实例但不初始化
    private static SingletonLazy singletonLazy = null;

    //私有化构造函数，防止外部应用类去再次实例化该类
    private SingletonLazy(){}
    //声明一个全局的静态的获取单例的方法
    /*public synchronized static SingletonLazy newInstance(){
        //判断该实例是否为null，如果为null进行创建，用于首次调用该实例
        if(singletonLazy == null){
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }*/
    
    
    public static SingletonLazy newInstance(){
        //外层判断是为了减少进入synchronized的线程，基本进入外层判断内部的会有首次调用的线程，之后的都会在这步进行阻拦
        if(singletonLazy == null){
        	synchronized (SingletonLazy.class) {
        		//内层判断是为了 多线程下 单例类还没实例化时，外层判断可能会导致有多个线程进入内部逻辑，为了防止多次实例化而加入内层判断
        		if(singletonLazy == null) {
        			singletonLazy = new SingletonLazy();
        		}
			}
        }
        return singletonLazy;
    }
}