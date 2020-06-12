package com.qding.eyecloud.web.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.ServletContainerSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.qding.eyecloud.web.auth2.OAuth2Filter;
import com.qding.eyecloud.web.auth2.OAuth2Realm;
import com.qding.eyecloud.web.xss.XssFilter;

/**
 * Shiro的配置文件
 */
@Configuration
public class ShiroConfig {
    
    /**
     * 单机环境，session交给shiro管理
     */
    @Bean
    @ConditionalOnProperty(prefix = "system", name = "cluster", havingValue = "false")
    public DefaultWebSessionManager sessionManager(
        @Value("${system.globalSessionTimeout:3600}") long globalSessionTimeout) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        sessionManager.setSessionValidationInterval(globalSessionTimeout * 1000);
        sessionManager.setGlobalSessionTimeout(globalSessionTimeout * 1000);
        
        return sessionManager;
    }

    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }
    
    /**
     * 集群环境，session交给spring-session管理
     */
    @Bean
    @ConditionalOnProperty(prefix = "system", name = "cluster", havingValue = "true")
    public ServletContainerSessionManager servletContainerSessionManager() {
        return new ServletContainerSessionManager();
    }
    
    @Bean
    public OAuth2Realm oAuth2Realm() {
        return new OAuth2Realm();
    }
    
    @Bean("securityManager")
    public SecurityManager securityManager(OAuth2Realm userRealm, SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setSessionManager(sessionManager);
        securityManager.setRememberMeManager(null);
        
        return securityManager;
    }
    
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        
        Map<String, Filter> filters = new HashMap<>();
        filters.put("auth", new OAuth2Filter());
        shiroFilter.setFilters(filters);
        
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/swagger/**", "anon");
        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/v2/qding-api-docs", "anon");
        filterMap.put("/swagger-ui.html", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        filterMap.put("/static/**", "anon");
        filterMap.put("/index", "anon");
        filterMap.put("/test", "anon");
        filterMap.put("/login.html", "anon");
        filterMap.put("/auth/login", "anon");
        filterMap.put("/auth/register", "anon");
        filterMap.put("/favicon.ico", "anon");
        filterMap.put("/captcha.jpg", "anon");
        filterMap.put("/**/*.png", "anon");
        filterMap.put("/**/*.jpg", "anon");
        filterMap.put("/**/*.jpeg", "anon");
        filterMap.put("/**/*.css", "anon");
        filterMap.put("/**/*.js", "anon");
        
        filterMap.put("/", "anon");
        filterMap.put("/**", "auth");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        
        return shiroFilter;
    }
    
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
    
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
    
    @Bean
    public FilterRegistrationBean<DelegatingFilterProxy> shiroFilterRegistration() {
        FilterRegistrationBean<DelegatingFilterProxy> registration = new FilterRegistrationBean<>();
        registration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        // 该值缺省为false，表示生命周期由SpringApplicationContext管理，设置为true则表示由ServletContainer管理
        registration.addInitParameter("targetFilterLifecycle", "true");
        registration.setEnabled(true);
        registration.setOrder(Integer.MAX_VALUE - 1);
        registration.addUrlPatterns("/*");
        return registration;
    }
    
    @Bean
    public FilterRegistrationBean<XssFilter> xssFilterRegistration() {
        FilterRegistrationBean<XssFilter> registration = new FilterRegistrationBean<>();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new XssFilter());
        registration.addUrlPatterns("/*");
        registration.setName("xssFilter");
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }
    
}
