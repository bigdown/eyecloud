package com.t.s.eyecloud.test;

import com.t.s.eyecloud.auth.remote.AuthRemoteApplication;
import com.t.s.eyecloud.common.utils.SnowFlake;
import com.t.s.eyecloud.dao.ICustomerDao;
import com.t.s.eyecloud.dao.IOrderItemsDao;
import com.t.s.eyecloud.dao.IOrdersDao;
import com.t.s.eyecloud.model.Customer;
import com.t.s.eyecloud.model.OrderItems;
import com.t.s.eyecloud.model.Orders;
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
public class Mycat {

    @Autowired
    private ICustomerDao iCustomerDao;

    @Autowired
    private IOrdersDao iOrdersDao;

    @Autowired
    private IOrderItemsDao iOrderItemsDao;

    @Test
    public void saveCustomerBatchTest() {
        int size = 2000;
        BlockingQueue blockingQueue = new LinkedBlockingQueue<Runnable>();
        Executor executor = new ThreadPoolExecutor(20, 1000, 30L, TimeUnit.SECONDS, blockingQueue);
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    List<Customer> list = new ArrayList<>();
                    int j = 0;
                    for (; j < 1000; j++) {
                        Customer customer = new Customer();
                        String id = String.valueOf(SnowFlake.createSnowFlake().nextId());
                        customer.setId(id);
                        customer.setName(id);
                        list.add(customer);
//                        iCustomerDao.save(customer);
                    }
                    iCustomerDao.saveBatch(list);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程都执行完毕，继续执行主线程");
    }

    @Test
    public void saveCustomerTest() {
        BlockingQueue blockingQueue = new LinkedBlockingQueue<Runnable>();
        Executor executor = new ThreadPoolExecutor(20, 1000, 30L, TimeUnit.SECONDS, blockingQueue);
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
//                    List<Customer> list = new ArrayList<>();
                    int j = 0;
                    for (; j < 1000; j++) {
                        Customer customer = new Customer();
                        String id = String.valueOf(SnowFlake.createSnowFlake().nextId());
                        customer.setId(id);
                        customer.setName(id);
                        iCustomerDao.save(customer);
                    }
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程都执行完毕，继续执行主线程");
    }


    @Test
    public void saveOrdersBatchTest() {
        int size = 16000;
        BlockingQueue blockingQueue = new LinkedBlockingQueue<Runnable>();
        Executor executor = new ThreadPoolExecutor(20, 1000, 30L, TimeUnit.SECONDS, blockingQueue);
        CountDownLatch countDownLatch = new CountDownLatch(size);
        List<String> list = new ArrayList<>();
        // select * FROM db1.customer
        list.add("72047357342056448");        list.add("72047357342056453");        list.add("72047357342056463");        list.add("72047357342056475");
        // select * FROM db2.customer
        list.add("72047357342056454");        list.add("72047357342056489");        list.add("72047357346250763");        list.add("72047357346250777");
        // select * FROM db3.customer
        list.add("72047357342056459");        list.add("72047357342056473");        list.add("72047357346250762");        list.add("72047357346250786");
        // select * FROM db4.customer
        list.add("72047357342056465");        list.add("72047357342056474");        list.add("72047357342056488");        list.add("72047357346250770");
        for (int i = 0; i < size; i++) {
            String customerId = list.get(i%16);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    List<Orders> list = new ArrayList<>();
                    int j = 0;
                    for (; j < 1000; j++) {
                        Orders orders = new Orders();
                        String id = String.valueOf(SnowFlake.createSnowFlake().nextId());
                        orders.setId(id);
                        orders.setCustomerId(customerId);
                        list.add(orders);
                    }
                    iOrdersDao.saveBatch(list);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程都执行完毕，继续执行主线程");
    }



    @Test
    public void saveOrdersItemBatchTest() {
        int size = 16000;
        BlockingQueue blockingQueue = new LinkedBlockingQueue<Runnable>();
        Executor executor = new ThreadPoolExecutor(20, 1000, 30L, TimeUnit.SECONDS, blockingQueue);
        CountDownLatch countDownLatch = new CountDownLatch(size);
        List<String> list = new ArrayList<>();
        // select * FROM db1.orders
        list.add("72067305724510208");        list.add("72067305724510213");        list.add("72067305724510217");        list.add("72067305724510222");
        // select * FROM db2.orders
        list.add("72067305749677594");        list.add("72067305749677596");        list.add("72067305749677619");        list.add("72067305749677663");
        // select * FROM db3.orders
        list.add("72067305737093326");        list.add("72067305737093362");        list.add("72067305737093397");        list.add("72067305737093451");
        // select * FROM db4.orders
        list.add("72067305724510265");        list.add("72067305724510374");        list.add("72067305728704553");        list.add("72067305728704683");
        for (int i = 0; i < size; i++) {
            String orderId = list.get(i%16);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    List<OrderItems> list = new ArrayList<>();
                    int j = 0;
                    for (; j < 1000; j++) {
                        OrderItems orders = new OrderItems();
                        String id = String.valueOf(SnowFlake.createSnowFlake().nextId());
                        orders.setId(id);
                        orders.setOrderId(orderId);
                        list.add(orders);
                    }
                    iOrderItemsDao.saveBatch(list);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程都执行完毕，继续执行主线程");
    }
}
