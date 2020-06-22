package com.qding.eyecloud.web.auth2;

import com.qding.eyecloud.common.exception.A;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.qding.eyecloud.common.exception.CommonException;
import com.qding.eyecloud.model.AuthUser;

public class ShiroUtils {

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static AuthUser getAuthUser() {
        return (AuthUser) SecurityUtils.getSubject().getPrincipal();
    }

    public static String getUserId() {
        AuthUser authUser = getAuthUser();
        A.checkAuth(authUser == null);
        return getAuthUser().getId();
    }

    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    public static String getKaptcha(String key) {
        Object kaptcha = getSessionAttribute(key);
        if (kaptcha == null) {
            throw new CommonException("验证码已失效");
        }
        getSession().removeAttribute(key);
        return kaptcha.toString();
    }
}
