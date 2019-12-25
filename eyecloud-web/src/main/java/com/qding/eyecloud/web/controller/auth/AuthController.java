package com.qding.eyecloud.web.controller.auth;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.qding.eyecloud.common.data.base.RestResponse;
import com.qding.eyecloud.model.AuthUser;
import com.qding.eyecloud.web.auth2.ShiroUtils;
import com.qding.eyecloud.web.facade.RpcFacade;

/**
 * 登录相关
 */
@Controller
public class AuthController {
    
    @Autowired
    private Producer producer;
    
    @Autowired
    private RpcFacade rpcFacade;
    
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response)
        throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        
        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }
    
    /**
     * 登录
     */
    @PostMapping(value = "/auth/login")
    @ResponseBody
    public RestResponse<AuthUser> login(@RequestParam(name = "username") String username,
        @RequestParam(name = "password") String password, @RequestParam String captcha) {
        // String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        // if (!captcha.equalsIgnoreCase(kaptcha)) {
        // return RestResponse.error("验证码不正确");
        // }
        // 调用登录逻辑
        AuthUser req = new AuthUser();
        req.setAccount(username);
        req.setPassword(password);
        AuthUser authUser = rpcFacade.iAuthFacade.getAuthUser(req, true, true);
        return RestResponse.ok(authUser);
    }
    
    /**
     * 注册
     */
    @PostMapping(value = "/auth/register")
    @ResponseBody
    public RestResponse<AuthUser> register(@RequestBody AuthUser req) {
        // 调用注册逻辑
        AuthUser authUser = rpcFacade.iAuthFacade.register(req);
        return RestResponse.ok(authUser);
    }
    
    /**
     * 退出
     */
    @GetMapping(value = "auth/logout")
    public String logout() {
        ShiroUtils.logout();
        return "redirect:login.html";
    }
}
