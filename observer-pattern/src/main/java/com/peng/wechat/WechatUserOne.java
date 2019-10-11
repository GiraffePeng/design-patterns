package com.peng.wechat;

//具体观察者角色 这里相当于微信个人号
public class WechatUserOne implements Observer{

	@Override
	public void response(String content) {
		System.out.println("微信号1接收到微信公众号发来的消息或者推文等,标题:" + content);
	}

}
