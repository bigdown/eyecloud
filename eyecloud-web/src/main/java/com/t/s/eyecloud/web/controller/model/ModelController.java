package com.t.s.eyecloud.web.controller.model;

import com.t.s.eyecloud.base.BaseModel;
import com.t.s.eyecloud.common.data.base.RestResponse;
import com.t.s.eyecloud.model.BaseProduct;
import com.t.s.eyecloud.model.BaseProductProperty;
import com.t.s.eyecloud.web.facade.RpcFacade;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @ApiOperation("/addProduct")
    @PostMapping(value = "/addProduct")
    @ResponseBody
    public RestResponse<BaseModel> addProduct(@RequestBody BaseProduct baseProduct) {
        return RestResponse.ok(rpcFacade.iModelFacade.addProduct(baseProduct));
    }

    @PostMapping(value = "/listProduct")
    @ResponseBody
    public RestResponse<List<BaseProduct>> listProduct(@RequestBody BaseProduct baseProduct) {
        return RestResponse.ok(rpcFacade.iModelFacade.listProduct(baseProduct));
    }

    @PostMapping(value = "/batchAddProductProperty")
    @ResponseBody
    public RestResponse<Boolean> batchAddProductProperty(List<BaseProductProperty> baseProductProperties) {
        return RestResponse.ok(rpcFacade.iModelFacade.batchAddProductProperty(baseProductProperties));
    }
}
