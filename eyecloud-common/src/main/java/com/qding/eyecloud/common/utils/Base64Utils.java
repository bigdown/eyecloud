package com.qding.eyecloud.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Random;

/**
 * Desc: Base64工具类
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
public class Base64Utils {

	public static final String B64T = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	public static final int P_INDEX = 6;

	public static void b64from24bit(byte b2, byte b1, byte b0, int outLen, StringBuilder buffer) {
		int w = b2 << 16 & 16777215 | b1 << 8 & '\uffff' | b0 & 255;

		for (int var6 = outLen; var6-- > 0; w >>= P_INDEX) {
			buffer.append(B64T.charAt(w & 63));
		}

	}

	public static String getRandomSalt(int num) {
		StringBuilder saltString = new StringBuilder();
		Random r = new Random();
		for (int i = 1; i <= num; ++i) {
			saltString.append(B64T.charAt(r.nextInt(B64T.length())));
		}

		return saltString.toString();
	}

	public static String encode(byte[] data) throws UnsupportedEncodingException {
		return new String(Base64.getEncoder().encode(data), AesUtils.CHARSET);
	}

	public static byte[] decode(String source) throws UnsupportedEncodingException {
		return Base64.getDecoder().decode(source.getBytes(AesUtils.CHARSET));
	}

	public static String getRandomSaltForSha256() {
		return "$5$" + getRandomSalt(13);
	}

	public static String getRandomSaltForSha512() {
		return "$6$" + getRandomSalt(125);
	}
}
