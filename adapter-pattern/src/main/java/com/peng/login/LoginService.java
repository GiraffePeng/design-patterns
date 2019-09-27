package com.peng.login;

//声明登陆信息操作接口
public interface LoginService {
	
	AccessToken login(TokenEndpointEntity tokenEndpointEntity);
}
