package com.qding.eyecloud.test;

import com.qding.eyecloud.auth.remote.AuthRemoteApplication;
import com.qding.eyecloud.common.utils.SnowFlake;
import com.qding.eyecloud.dao.ICustomerDao;
import com.qding.eyecloud.dao.IOrderItemsDao;
import com.qding.eyecloud.dao.IOrdersDao;
import com.qding.eyecloud.model.Customer;
import com.qding.eyecloud.model.OrderItems;
import com.qding.eyecloud.model.Orders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthRemoteApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class Redis {

}
