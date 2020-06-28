package com.t.s.eyecloud.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Desc: sha加密工具类
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
public class ShaUtils {

	private static final Logger logger = LoggerFactory.getLogger(ShaUtils.class);
	public static final String SHA_256 = "SHA-256";
	public static final String SHA_512 = "SHA-512";

	public static String shaxxx(String password, String salt, String algorithm) {
		MessageDigest messageDigest;
		String cipherStr = password;
		try {
			messageDigest = MessageDigest.getInstance(algorithm);
			// 调用digest方法，进行加密操作
			byte[] cipherBytes = messageDigest.digest((password + salt).getBytes());
			cipherStr = Hex.encodeHexString(cipherBytes);
		} catch (NoSuchAlgorithmException e) {
			logger.error("加密算法异常：[{}]", e.getMessage());
		}
		return cipherStr;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(shaxxx("1", "123", SHA_512));
	}
}
