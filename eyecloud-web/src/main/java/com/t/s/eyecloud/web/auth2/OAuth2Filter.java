package com.t.s.eyecloud.web.auth2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.t.s.eyecloud.common.data.base.RestResponse;

/**
 * oauth2过滤器
 */
public class OAuth2Filter extends AuthenticatingFilter {

	private static final Logger logger = LoggerFactory.getLogger(OAuth2Filter.class);

	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
		// 获取请求token
		String token = getRequestToken((HttpServletRequest) request);
		if (StringUtils.isBlank(token)) {
			return null;
		}
		return new OAuth2Token(token);
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// 获取请求token，如果token不存在，直接返回401
		String token = getRequestToken((HttpServletRequest) request);
		if (StringUtils.isBlank(token)) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.setContentType("application/json;charset=utf-8");
			PrintWriter out = null;
			try {
				String json = JSONObject.toJSONString(
						RestResponse.error(String.valueOf(HttpStatus.SC_UNAUTHORIZED), "Token is not exist!"));
				out = httpResponse.getWriter();
				out.print(json);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (out != null) {
					out.close();
				}
			}
			return false;
		}
		return executeLogin(request, response);
	}

	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setContentType("application/json;charset=utf-8");
		PrintWriter printWriter = null;
		try {
			printWriter = httpResponse.getWriter();
			printWriter.print(JSONObject
					.toJSONString(RestResponse.error(String.valueOf(HttpStatus.SC_UNAUTHORIZED), "登录异常，请重新登录")));
		} catch (Exception exception) {
			logger.error("login fail [{}]", exception.getMessage());
			printWriter.print(JSONObject
					.toJSONString(RestResponse.error(String.valueOf(HttpStatus.SC_UNAUTHORIZED), "登录异常，请重新登录")));
		} finally {
			if (printWriter != null)
				printWriter.close();
		}
		return false;
	}

	/**
	 * 获取请求的token
	 *
	 */
	private String getRequestToken(HttpServletRequest httpRequest) {
		// 从header中获取token
		String token = httpRequest.getHeader("token");
		// 如果header中不存在token，则从参数中获取token
		if (StringUtils.isBlank(token)) {
			token = httpRequest.getParameter("token");
		}
		return token;
	}

}
