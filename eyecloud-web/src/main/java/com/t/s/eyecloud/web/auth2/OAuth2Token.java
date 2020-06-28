package com.t.s.eyecloud.web.auth2;

import org.apache.shiro.authc.AuthenticationToken;

public class OAuth2Token implements AuthenticationToken {

	private static final long serialVersionUID = -6540851949247981574L;

	private String token;

	private boolean isLogin;

	public OAuth2Token(String token) {
		this.token = token;
	}

	public OAuth2Token(String token, boolean isLogin) {
		this.token = token;
		this.isLogin = isLogin;
	}

	@Override
	public String getPrincipal() {
		return token;
	}

	@Override
	public Object getCredentials() {
		return token;
	}

	public boolean getIsLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

}
