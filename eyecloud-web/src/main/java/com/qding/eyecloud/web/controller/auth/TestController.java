package com.qding.eyecloud.web.controller.auth;

import com.qding.eyecloud.web.utils.RedisUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RestController
@RequestMapping("test")
public class TestController {
    
    /**
     * test
     */
    @RequestMapping(value = "test", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"auth:test"})
    public String test() {
        return "test";
    }

    @RequestMapping(value = "jedis", method = RequestMethod.POST)
    @ResponseBody
    public String jedis(HttpServletRequest request) {

        String lua = "local num = redis.call('incr', KEYS[1])\n" +
                "if tonumber(num) == 1 then\n" +
                "\tredis.call('expire', KEYS[1], ARGV[1])\n" +
                "\treturn 1\n" +
                "elseif tonumber(num) > tonumber(ARGV[2]) then\n" +
                "\treturn 0\n" +
                "else \n" +
                "\treturn 1\n" +
                "end\n";
        Object result = RedisUtil.getRedisUtil().evalsha(lua, Arrays.asList("localhost"), Arrays.asList("10", "2"));
        return "result" + result.toString();
    }
}
