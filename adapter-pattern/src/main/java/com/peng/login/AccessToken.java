package com.peng.login;

/**
 * 创建登陆接口 返回实体
 */
public class AccessToken {

	private String access_token;
	
	private String token_type;
	
	private String refresh_token;
	
	private Long expires_in;
	
	private String scope;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public Long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
	
	public AccessToken() {
		super();
	}
	
	public AccessToken(String access_token, String token_type, String refresh_token, Long expires_in, String scope) {
		super();
		this.access_token = access_token;
		this.token_type = token_type;
		this.refresh_token = refresh_token;
		this.expires_in = expires_in;
		this.scope = scope;
	}



	static class AccessTokenBuilder{
		private String access_token;
		
		private String token_type;
		
		private String refresh_token;
		
		private Long expires_in;
		
		private String scope;
		
		public AccessTokenBuilder access_token(String access_token) {
			this.access_token = access_token;
			return this;
		}
		
		public AccessTokenBuilder token_type(String token_type) {
			this.token_type = token_type;
			return this;
		}
		
		public AccessTokenBuilder refresh_token(String refresh_token) {
			this.refresh_token = refresh_token;
			return this;
		}
		
		public AccessTokenBuilder expires_in(Long expires_in) {
			this.expires_in = expires_in;
			return this;
		}
		
		public AccessTokenBuilder scope(String scope) {
			this.scope = scope;
			return this;
		}
		
		public AccessToken build() {
			return new AccessToken(access_token, token_type, refresh_token, expires_in, scope);
		}
	}
	
	public static AccessTokenBuilder builder() {
		return new AccessTokenBuilder();
	}
}
