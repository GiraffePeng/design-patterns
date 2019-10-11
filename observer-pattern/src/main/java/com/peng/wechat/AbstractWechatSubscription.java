package com.peng.wechat;

import java.util.ArrayList;
import java.util.List;

//抽象主题角色：抽象目标类，在观察者模式一对多中 扮演 一的角色
public abstract class AbstractWechatSubscription {

	protected List<Observer> observers = new ArrayList<Observer>();
	
	//相当于提供了微信号关注订阅号的功能
	public AbstractWechatSubscription add(Observer observer) {
		observers.add(observer);
		return this;
	}
	
	//相当于提供了微信号取消关注订阅号的功能
	public void remove(Observer observer) {
		observers.remove(observer);
	}
	
	//声明通知观察者的方法，当该订阅号需要通知微信号推文或者消息时，调用该方法。
	public abstract void notifyObserver(String content);
}
