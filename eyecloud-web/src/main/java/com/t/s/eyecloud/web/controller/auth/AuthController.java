package com.t.s.eyecloud.web.controller.auth;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.t.s.eyecloud.common.data.base.RestResponse;
import com.t.s.eyecloud.common.data.request.auth.LoginVO;
import com.t.s.eyecloud.common.data.response.auth.AuthUserVO;
import com.t.s.eyecloud.common.data.response.auth.UserDataVO;
import com.t.s.eyecloud.model.AuthUser;
import com.t.s.eyecloud.web.auth2.ShiroUtils;
import com.t.s.eyecloud.web.cache.RedisCache;
import com.t.s.eyecloud.web.facade.RpcFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登录相关
 * @author Administrator
 */
@Controller
public class AuthController {

    @Resource
    private Producer producer;

    @Resource
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
    public RestResponse<AuthUserVO> login(@RequestBody LoginVO loginVO) {
        // String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        // if (!captcha.equalsIgnoreCase(kaptcha)) {
        // return RestResponse.error("验证码不正确");
        // }
        // 调用登录逻辑
        AuthUser req = new AuthUser();
        req.setAccount(loginVO.getUsername());
        req.setPassword(loginVO.getPassword());
        AuthUserVO authUser = rpcFacade.iAuthFacade.getAuthUser(req, true, true);
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
     * 获取用户基本信息以及权限菜单
     *
     * @return
     */
    @PostMapping(value = "/auth/permissions")
    @ResponseBody
    public RestResponse<UserDataVO> getUserMenuOperates() {
        return RestResponse.ok(RedisCache.getAndSetUserCache(ShiroUtils.getUserId()));
    }
}
