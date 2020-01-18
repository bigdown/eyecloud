package com.qding.eyecloud.video.remote.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http工具类
 * <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年10月23日
 */
public class HttpUtils {
	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);
	private static final String CHARSET = "UTF-8";

	/**
	 * http get请求
	 *
	 * @param url
	 * @return
	 */
	public static String get(String url) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try {
			httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			// 设置请求和传输超时时间
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000)
					.setConnectionRequestTimeout(5000).setConnectTimeout(5000).build();
			httpGet.setConfig(requestConfig);
			// httpGet.addHeader("stoken","8464465"); 添加header信息
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (Objects.nonNull(entity)) {
				String str = EntityUtils.toString(entity, CHARSET);
				return str;
			}
		} catch (Exception e) {
			logger.error("get url {} error", url);
		} finally {
			try {
				if (Objects.nonNull(response)) {
					response.close();
				}
				if (Objects.nonNull(httpClient)) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	/**
	 * http get请求
	 *
	 * @param url
	 * @return
	 */
	public static String get(String url, String token) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try {

			httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			// 设置请求和传输超时时间
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(3000)
					.setConnectionRequestTimeout(3000).setConnectTimeout(3000).build();
			httpGet.setConfig(requestConfig);
			if (StringUtils.isNotEmpty(token)) {
				httpGet.addHeader("qd-token", token);
			}
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (Objects.nonNull(entity)) {
				String str = EntityUtils.toString(entity, CHARSET);
				return str;
			}
		} catch (Exception e) {
			logger.error("get url {} error", url);
		} finally {
			try {
				if (Objects.nonNull(response)) {
					response.close();
				}
				if (Objects.nonNull(httpClient)) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	public static String getOfheader(String url, String headname, String headValue) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try {
			httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			// 设置请求和传输超时时间
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000)
					.setConnectionRequestTimeout(5000).setConnectTimeout(5000).build();
			httpGet.setConfig(requestConfig);
			httpGet.addHeader(headname, headValue);
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (Objects.nonNull(entity)) {
				String str = EntityUtils.toString(entity, CHARSET);
				return str;
			}
		} catch (Exception e) {
			logger.error("get url {} error", url);
		} finally {
			try {
				if (Objects.nonNull(response)) {
					response.close();
				}
				if (Objects.nonNull(httpClient)) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	/**
	 * http get请求
	 *
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static String get(String url, Map<String, ?> params, String token)
			throws ClientProtocolException, IOException {

		if (params != null && !params.isEmpty()) {
			List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
			for (String key : params.keySet()) {
				pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
			}
			url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs), CHARSET);
		}

		CloseableHttpClient httpClient = createSSLClientDefault();
		CloseableHttpResponse response = null;
		HttpGet httpGet = new HttpGet(url);

		if (StringUtils.isNotBlank(token)) {
			httpGet.setHeader("stoken", token);
		}
		// 设置请求和传输超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(3000).setConnectionRequestTimeout(3000)
				.setConnectTimeout(3000).build();
		httpGet.setConfig(requestConfig);
		response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if (Objects.nonNull(entity)) {
			String str = EntityUtils.toString(entity, CHARSET);
			return str;
		}
		logger.error("http get is error, url is <{}>", url);
		return null;
	}

	/**
	 * get
	 *
	 * @param host
	 * @param path
	 * @param method
	 * @param headers
	 * @param querys
	 * @return
	 * @throws Exception
	 */
	public static HttpResponse doGet(String host, String path, String method, Map<String, String> headers,
			Map<String, String> querys) throws Exception {
		HttpClient httpClient = HttpClients.createDefault();
		// 设置请求和传输超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectionRequestTimeout(5000)
				.setConnectTimeout(5000).build();
		HttpGet request = new HttpGet(buildUrl(host, path, querys));
		request.setConfig(requestConfig);
		for (Map.Entry<String, String> e : headers.entrySet()) {
			request.addHeader(e.getKey(), e.getValue());
		}

		return httpClient.execute(request);
	}

	/**
	 * http post请求（数据编码格式application/x-www-form-urlencoded）
	 *
	 * @param url
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @return
	 */
	public static String post(String url, Map<String, Object> params) {
		try {
			logger.debug(url);
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000)
					.setConnectionRequestTimeout(1000).setConnectTimeout(5000).build();
			httpPost.setConfig(requestConfig);

			List<NameValuePair> parameters = new ArrayList<NameValuePair>();

			for (Iterator<String> iterator = params.keySet().iterator(); iterator.hasNext();) {
				String key = iterator.next();
				parameters.add(new BasicNameValuePair(key, params.get(key).toString()));
			}

			UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(parameters, CHARSET);
			httpPost.setEntity(urlEncodedFormEntity);
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String str = EntityUtils.toString(entity, CHARSET);
					return str;
				}
			} finally {
				response.close();
				httpClient.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * http post请求（数据编码格式application/x-www-form-urlencoded）
	 *
	 * @param url
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @return
	 */
	public static String post(String url, Map<String, Object> params, String token) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			if (StringUtils.isNotEmpty(token)) {
				httpPost.addHeader("qd-token", token);
			}
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();

			if (params != null) {
				for (Iterator<String> iterator = params.keySet().iterator(); iterator.hasNext();) {
					String key = iterator.next();
					parameters.add(new BasicNameValuePair(key, params.get(key).toString()));
				}
			}

			UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(parameters, CHARSET);
			httpPost.setEntity(urlEncodedFormEntity);
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String str = EntityUtils.toString(entity, CHARSET);
					return str;
				}
			} finally {
				response.close();
				httpClient.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String postByToken(String url, Map<String, ?> params, String token) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000)
					.setConnectionRequestTimeout(5000).setConnectTimeout(5000).build();
			httpPost.setConfig(requestConfig);

			List<NameValuePair> parameters = new ArrayList<NameValuePair>();

			if (params != null) {
				for (Iterator<String> iterator = params.keySet().iterator(); iterator.hasNext();) {
					String key = iterator.next();
					parameters.add(new BasicNameValuePair(key, params.get(key).toString()));
				}
				UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(parameters, CHARSET);
				httpPost.setEntity(urlEncodedFormEntity);
			}
			if (StringUtils.isNotBlank(token)) {
				httpPost.setHeader("stoken", token);
			}
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String str = EntityUtils.toString(entity, CHARSET);
					return str;
				}
			} finally {
				response.close();
				httpClient.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * http post请求（数据编码格式application/x-www-form-urlencoded）
	 *
	 * @param url
	 *            请求地址
	 * @param params
	 *            请求参数(参数格式："key1=value1&key2=value2")
	 * @return
	 */
	public static String post(String url, String params) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000)
					.setConnectionRequestTimeout(1000).setConnectTimeout(5000).build();
			httpPost.setConfig(requestConfig);

			StringEntity stringEntity = new StringEntity(params, CHARSET);
			stringEntity.setContentType("application/x-www-form-urlencoded");
			httpPost.setEntity(stringEntity);
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String str = EntityUtils.toString(entity, CHARSET);
					return str;
				}
			} finally {
				response.close();
				httpClient.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String postOfHeader(String url, String params, String headName, String headValue) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000)
					.setConnectionRequestTimeout(1000).setConnectTimeout(5000).build();
			httpPost.setConfig(requestConfig);
			httpPost.addHeader(headName, headValue);
			StringEntity stringEntity = new StringEntity(params, CHARSET);
			stringEntity.setContentType("application/x-www-form-urlencoded");
			httpPost.setEntity(stringEntity);
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String str = EntityUtils.toString(entity, CHARSET);
					return str;
				}
			} finally {
				response.close();
				httpClient.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * http post请求（数据编码格式application/json）
	 *
	 * @param url
	 *            请求地址
	 * @param json
	 *            请求参数（参数格式为json字符串）
	 * @return
	 */
	public static String postJson(String url, String json) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);

			RequestConfig requestConfig = RequestConfig.custom()/*
																 * .setSocketTimeout(5000)
																 * .setConnectionRequestTimeout(5000).setConnectTimeout(5000)
																 */.build();
			httpPost.setConfig(requestConfig);

			StringEntity stringEntity = new StringEntity(json, CHARSET);
			// 数据编码格式
			stringEntity.setContentType("application/json");
			httpPost.setEntity(stringEntity);
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					return EntityUtils.toString(entity, CHARSET);
				}
			} finally {
				response.close();
				httpClient.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * http post请求（数据编码格式application/json）
	 * 
	 * @param url
	 * @param json
	 * @param token
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static String postJson(String url, String json, String token) {
		try {
			CloseableHttpClient httpClient = createSSLClientDefault();
			HttpPost httpPost = new HttpPost(url);

			RequestConfig requestConfig = RequestConfig.custom()./*
																	 * setSocketTimeout(5000).setConnectionRequestTimeout(1000)
																	 * .setConnectTimeout(5000).
																	 */build();
			httpPost.setConfig(requestConfig);

			StringEntity stringEntity = new StringEntity(json, CHARSET);
			// 数据编码格式
			stringEntity.setContentType("application/json");
			if (StringUtils.isNotBlank(token)) {
				httpPost.setHeader("stoken", token);
			}
			httpPost.setEntity(stringEntity);
			CloseableHttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				return EntityUtils.toString(entity, CHARSET);
			}
			logger.error("http post is error, url is <{}>, data is <{}>", url, json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static CloseableHttpClient createSSLClientDefault() {
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				// 信任所有
				@Override
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			}).build();
			HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
			return HttpClients.custom().setDefaultRequestConfig(requestConfig).setSSLSocketFactory(sslsf).build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		return HttpClients.createDefault();
	}

	/**
	 * 发送https请求
	 * 
	 * @param jsonPara
	 * @throws Exception
	 */
	public static String postByHttps(Map<String, Object> params, String url) {

		CloseableHttpClient httpClient;
		CloseableHttpResponse httpResponse;
		try {
			HttpPost httpPost = new HttpPost(url);
			List<NameValuePair> listNVP = new ArrayList<NameValuePair>();
			if (params != null) {
				for (String key : params.keySet()) {
					listNVP.add(new BasicNameValuePair(key, params.get(key).toString()));
				}
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(listNVP, "UTF-8");
			httpPost.setEntity(entity);
			httpPost.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
			httpClient = createSSLClientDefault();
			httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			if (httpEntity != null) {
				String jsObject = EntityUtils.toString(httpEntity, "UTF-8");
				return jsObject;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("请求异常", e);
			return null;
		} finally {
		}
	}

	/**
	 * 发送https请求
	 * 
	 * @param jsonPara
	 * @throws Exception
	 */
	public static String getByHttps(String url) {

		CloseableHttpClient httpClient;
		CloseableHttpResponse httpResponse;
		try {
			HttpGet httpPost = new HttpGet(url);
			httpPost.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
			httpClient = createSSLClientDefault();
			httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			if (httpEntity != null) {
				String jsObject = EntityUtils.toString(httpEntity, "UTF-8");
				return jsObject;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("请求异常", e);
			return null;
		} finally {
		}
	}

	private static String buildUrl(String host, String path, Map<String, String> querys)
			throws UnsupportedEncodingException {
		StringBuilder sbUrl = new StringBuilder();
		sbUrl.append(host);
		if (!StringUtils.isBlank(path)) {
			sbUrl.append(path);
		}
		if (null != querys) {
			StringBuilder sbQuery = new StringBuilder();
			for (Map.Entry<String, String> query : querys.entrySet()) {
				if (0 < sbQuery.length()) {
					sbQuery.append("&");
				}
				if (StringUtils.isBlank(query.getKey()) && !StringUtils.isBlank(query.getValue())) {
					sbQuery.append(query.getValue());
				}
				if (!StringUtils.isBlank(query.getKey())) {
					sbQuery.append(query.getKey());
					if (!StringUtils.isBlank(query.getValue())) {
						sbQuery.append("=");
						sbQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
					}
				}
			}
			if (0 < sbQuery.length()) {
				sbUrl.append("?").append(sbQuery);
			}
		}

		return sbUrl.toString();
	}
}
