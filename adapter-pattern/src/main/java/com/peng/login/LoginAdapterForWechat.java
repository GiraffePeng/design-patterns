package com.peng.login;

public class LoginAdapterForWechat extends LoginServiceImpl implements LoginAdapter{

	@Override
	public AccessToken login(String onlyFlag) {
		//根据onlyFlag(即openId)去查询 用户信息
		//根据查询出来的数据 组装TokenEndpointEntity
		TokenEndpointEntity tokenEndpointEntity = new TokenEndpointEntity();
		tokenEndpointEntity.setUsername("");
		tokenEndpointEntity.setPassword("");
		tokenEndpointEntity.setGrant_type("password");
		return login(tokenEndpointEntity);
	}

}
