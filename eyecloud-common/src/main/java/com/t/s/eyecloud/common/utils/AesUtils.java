package com.t.s.eyecloud.common.utils;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Desc: AES 加密算法工具类
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
public class AesUtils {

    /**
     * 加密算法 AES
     */
    private static final String KEY_ALGORITHM = "AES";

    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    public static final String CHARSET = "UTF-8";

    /**
     * 获取新的 AES 算法 SecretKey
     * @return SecretKey
     * @throws Exception 异常
     */
    public static SecretKey getSecretKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        return keyGenerator.generateKey();
    }

    /**
     * 还原密钥
     * @param secretBytes byte[]
     * @return SecretKey
     */
    public static SecretKey restoreSecretKey(byte[] secretBytes) {
        return new SecretKeySpec(secretBytes, KEY_ALGORITHM);
    }

    /**
     * 使用SecretKey加密
     * @param source 源数据
     * @param key SecretKey
     * @return 加密后数据
     * @throws Exception 加密异常
     */
    private static byte[] encrypt(byte[] source, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(source);
    }

    /**
     * 使用SecretKey加密字符串
     * @param source 字符串
     * @param key SecretKey
     * @return 加密后Base64字符串
     * @throws Exception 加密异常
     */
    public static String encrypt(String source, SecretKey key) throws Exception {
        byte[] sourceData = source.getBytes(CHARSET);
        byte[] encryptedData = encrypt(sourceData, key);
        return Base64Utils.encode(encryptedData);
    }

    /**
     * 使用SecretKey解密
     * @param encrypt 加密数据
     * @param key SecretKey
     * @return 解密后数据
     * @throws Exception 解密异常
     */
    private static byte[] decrypt(byte[] encrypt, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(encrypt);
    }

    /**
     * 使用SecretKey解密
     * @param encryptVal 加密Base64字符串
     * @param key SecretKey
     * @return 解密后字符串
     * @throws Exception 解密异常
     */
    public static String decrypt(String encryptVal, SecretKey key) throws Exception {
        byte[] encrypt = Base64Utils.decode(encryptVal);
        byte[] decrypt = decrypt(encrypt, key);
        return new String(decrypt,CHARSET);
    }
}
