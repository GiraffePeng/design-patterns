package com.peng.login.decorator;

//后置拓展类 具体抽象装饰角色
public class DoSuffixLoginServiceImpl extends AbstractLoginServiceImpl{

	public DoSuffixLoginServiceImpl(LoginService loginService) {
		super(loginService);
	}

	public void login() {
		super.login();
		doSomething();
	}

	public void doSomething() {
		System.out.println("在方法后拓展一些方法");
	}
}
