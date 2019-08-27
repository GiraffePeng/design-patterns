package com.peng.hungrysingleton;

public class SingletonHungry {
	//私有化构造函数，使其不能从外部进行实例化。
    private SingletonHungry(){}
	//静态的不可修改的单例实例
    //private static final SingletonHungry singletonHungry = new SingletonHungry();
    private static final SingletonHungry singletonHungry;
    //使用静态代码块来实现单例的实例化
    static{
        singletonHungry = new SingletonHungry();
    }
    
    //全局的静态的访问点，返回实例
    public static SingletonHungry newInstance(){
        return singletonHungry;
    }
}
