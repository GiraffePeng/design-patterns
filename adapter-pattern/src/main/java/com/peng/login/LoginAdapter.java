package com.peng.login;

//声明登陆适配器接口
public interface LoginAdapter {
	
	/**
	 * 登陆
	 * @param onlyFlag 传入 唯一标识 比如微信的openId
	 * @return
	 */
	AccessToken login(String onlyFlag);
	
}
