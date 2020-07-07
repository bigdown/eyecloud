package com.t.s.eyecloud.web.controller.model;

import com.t.s.eyecloud.common.data.base.RestResponse;
import com.t.s.eyecloud.web.facade.RpcFacade;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
@RequestMapping("/model")
@RestController
public class ModelController {

    @Resource
    private RpcFacade rpcFacade;

    @PostMapping(value = "/list")
    @ResponseBody
    public RestResponse<List<Map<String, String>>> list() {
        return RestResponse.ok(rpcFacade.iModelFacade.listModel());
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public RestResponse<Map<String, String>> add(@RequestBody Map<String, String> map) {
        return RestResponse.ok(rpcFacade.iModelFacade.addModel(map));
    }

    @PostMapping(value = "/remove")
    @ResponseBody
    public RestResponse<Boolean> remove(String topic) {
        return RestResponse.ok(rpcFacade.iModelFacade.removeModel(topic));
    }

}
