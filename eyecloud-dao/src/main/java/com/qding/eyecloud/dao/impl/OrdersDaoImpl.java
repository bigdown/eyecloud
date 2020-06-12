package com.qding.eyecloud.dao.impl;

import com.qding.eyecloud.model.Orders;
import com.qding.eyecloud.mapper.OrdersMapper;
import com.qding.eyecloud.dao.IOrdersDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * orders 服务实现类
 * </p>
 *
 * @author CodeGenerator
 * @since 2020-06-09
 */
@Service
public class OrdersDaoImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersDao {

}
