package com.qding.eyecloud.auth.remote.utils;

import java.util.Date;
import java.util.Random;

import com.qding.eyecloud.common.exception.CommonException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

public class JwtUtils {

    private JwtUtils() {

    }

    public static final String TOKEN_HEADER = "token";

    public static final String TOKEN_PREFIX = "eyecloud ";

    private static final String SECRET = "jwt-eyecloud-secret";

    private static final String ISS = "eyecloud";

    // 过期时间是3600秒，既是1个小时
    public static final long EXPIRATION = 604800L;

    // 选择了记住我之后的过期时间为7天
    public static final long EXPIRATION_REMEMBER = 604800L;

    /**
     * 创建token
     * 注：如果是根据可变的唯一值来生成，唯一值变化时，需重新生成token
     * @param isRememberMe
     * @return
     */
    public static String createToken(String id, String json, boolean isRememberMe) {
        long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;
        // 可以将基本不重要的对象信息放到claims中，此处信息不多,见简单直接放到配置内
        // id是重要信息，进行加密下
        String encryId = id;
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, SECRET)
            // 这里要早set一点，放到后面会覆盖别的字段
            // .setClaims(claims)
            .setIssuer(ISS)
            .setId(encryId)
            .setSubject(json)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
            .compact();
    }

    /**
     * 从token中获取用户名
     * @param token
     * @return
     */
    public static String getSubject(String token) {
        return getTokenBody(token).getSubject();
    }

    /**
     * 从token中获取ID，同时做解密处理
     * @param token
     * @return
     */
    public static String getObjectId(String token) {
        return getTokenBody(token).getId();
    }

    /**
     * 获取token信息，同时也做校验处理
     * @param token
     * @return
     */
    public static Claims getTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException expired) {
            // 过期
            throw new CommonException("token过期", "401");
        } catch (SignatureException e) {
            // 无效
            throw new CommonException("token失效", "401");
        }
    }

    public static String generateSalt() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        return sb.toString();
    }
}
