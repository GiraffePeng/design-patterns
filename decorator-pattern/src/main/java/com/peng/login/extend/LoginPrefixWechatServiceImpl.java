package com.peng.login.extend;

//微信登录子类
public class LoginPrefixWechatServiceImpl extends LoginWechatServiceImpl{

	@Override
	public void login() {
		doSomething();
		super.login();
	}

	public void doSomething() {
		System.out.println("拓展一些方法");
	}
}
