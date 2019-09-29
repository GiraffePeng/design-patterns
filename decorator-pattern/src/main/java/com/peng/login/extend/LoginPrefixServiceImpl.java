package com.peng.login.extend;

//普通登录子类
public class LoginPrefixServiceImpl extends LoginBaseServiceImpl{

	@Override
	public void login() {
		doSomething();
		super.login();
	}

	public void doSomething() {
		System.out.println("拓展一些方法");
	}
}
