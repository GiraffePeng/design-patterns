package com.peng.login.decorator;

//装饰器 抽象装饰角色
public abstract class AbstractLoginServiceImpl implements LoginService{

	private LoginService loginService;

	public AbstractLoginServiceImpl(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
	
	public void login() {
		loginService.login();
	}
}
