package com.peng.login.extend;

//QQ登录子类
public class LoginPrefixQQServiceImpl extends LoginQQServiceImpl{

	@Override
	public void login() {
		doSomething();
		super.login();
	}

	public void doSomething() {
		System.out.println("拓展一些方法");
	}
}
