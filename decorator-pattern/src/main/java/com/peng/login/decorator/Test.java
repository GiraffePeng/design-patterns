package com.peng.login.decorator;

public class Test {

	public static void main(String[] args) {
		LoginService loginService = new LoginQQServiceImpl();
		loginService.login();
		System.out.println("---------");
		
		//在方法前拓展内容
		LoginService doPrefixLoginService = new DoPrefixLoginServiceImpl(loginService);
		doPrefixLoginService.login();
		
		System.out.println("---------");
		
		//想在方法后拓展内容
		LoginService doSuffixLoginService = new DoSuffixLoginServiceImpl(loginService);
		doSuffixLoginService.login();
		
		System.out.println("---------");
		//即想在方法前拓展内容 ，又想在方法后拓展内容
		LoginService doSuffixAndPrefixLoginService = new DoSuffixLoginServiceImpl(doPrefixLoginService);
		doSuffixAndPrefixLoginService.login();
	}
}
