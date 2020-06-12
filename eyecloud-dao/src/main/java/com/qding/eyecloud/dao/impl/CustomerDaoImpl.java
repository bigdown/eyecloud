package com.qding.eyecloud.dao.impl;

import com.qding.eyecloud.model.Customer;
import com.qding.eyecloud.mapper.CustomerMapper;
import com.qding.eyecloud.dao.ICustomerDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * customer 服务实现类
 * </p>
 *
 * @author CodeGenerator
 * @since 2020-06-09
 */
@Service
public class CustomerDaoImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerDao {

}
