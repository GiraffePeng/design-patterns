package com.peng.wechat;

//具体目标类,它实现抽象目标中的通知方法，当具体主题的内部状态发生改变时，通知所有注册过的观察者对象。
public class WechatSubscription extends AbstractWechatSubscription{

	@Override
	public void notifyObserver(String content) {
		for(Observer observer:observers) {
			observer.response(content);
		}
	}
}
