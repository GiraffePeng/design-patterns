package com.peng.login.decorator;

//前置拓展类 具体抽象装饰角色
public class DoPrefixLoginServiceImpl extends AbstractLoginServiceImpl{

	public DoPrefixLoginServiceImpl(LoginService loginService) {
		super(loginService);
	}

	public void login() {
		doSomething();
		super.login();
	}

	public void doSomething() {
		System.out.println("在方法前拓展一些方法");
	}
}
