package com.t.s.eyeclod.data.center.facade;

import com.t.s.eyecloud.model.BaseProduct;
import com.t.s.eyecloud.model.BaseProductProperty;

import java.util.List;
import java.util.Map;

/**
 * description: 物模型定义接口
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
public interface IModelFacade {

    /**
     * description: 新增监听
     * info: <详细信息>
     * @since [产品/模块版本]
     * @return
     * @author: tanshen@qding.me
     * @Date: 2020年07月07日 11:10
     */
    Map<String, String> addModel(Map<String, String> map);

    /**
     * description: 查询所有监听
     * info: <详细信息>
     * @since [产品/模块版本]
     * @return
     * @author: tanshen@qding.me
     * @Date: 2020年07月07日 11:11
     */
    List<Map<String, String>> listModel();

    /**
     * description: 删除监听
     * info: <详细信息>
     * @since [产品/模块版本]
     * @return
     * @author: tanshen@qding.me
     * @Date: 2020年07月07日 11:12
     */
    boolean removeModel(String topic);

    /**
     * description: 新增产品
     * info: <详细信息>
     * @since [产品/模块版本]
     * @return
     * @author: tanshen@qding.me
     * @Date: 2020年07月08日 10:45
     */
    BaseProduct addProduct(BaseProduct baseProduct);

    /**
     * description: 查询产品列表
     * info: <详细信息>
     * @since [产品/模块版本]
     * @return
     * @author: tanshen@qding.me
     * @Date: 2020年07月08日 10:45
     */
    List<BaseProduct> listProduct(BaseProduct baseProduct);

    /**
     * description: 批量新增产品属性
     * info: <详细信息>
     * @since [产品/模块版本]
     * @return
     * @author: tanshen@qding.me
     * @Date: 2020年07月08日 14:14
     */
    Boolean batchAddProductProperty(List<BaseProductProperty> baseProductProperties);
}
