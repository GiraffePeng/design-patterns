package com.peng.wechat;

public class TestWechat {
	public static void main(String[] args) {
		AbstractWechatSubscription wechatSubscription = new WechatSubscription();
		
		Observer wechatUserOne = new WechatUserOne();
		
		Observer wechatUserTwo = new WechatUserTwo();
		//微信号1和微信号2关注了公众号
		wechatSubscription.add(wechatUserOne).add(wechatUserTwo);
		
		//发送推文
		wechatSubscription.notifyObserver("文章内容");
		
		System.out.println("------------------");
		System.out.println("微信号2取消关注了公众号");
		//微信号2取消关注该公众号
		wechatSubscription.remove(wechatUserTwo);
		
		//发送推文
		wechatSubscription.notifyObserver("第二篇文章内容");
	}
}
