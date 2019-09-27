package com.peng.login;

import java.util.UUID;

public class LoginServiceImpl implements LoginService {

	@Override
	public AccessToken login(TokenEndpointEntity tokenEndpointEntity) {
		// 交互数据库取出用户信息进行比对
		
		// 拼装返回数据
		return AccessToken.builder().access_token(String.valueOf(UUID.randomUUID())).expires_in(1000L)
				.refresh_token(String.valueOf(UUID.randomUUID())).scope("service").token_type("barear").build();
	}

}
