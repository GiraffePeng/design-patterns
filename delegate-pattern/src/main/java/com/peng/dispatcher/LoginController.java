package com.peng.dispatcher;

public class LoginController {

	@RequestMapping("/login")
	public void login(String username,String password) {
		System.out.println("登陆,账号:"+username+" 密码:"+password);
	}
}
