package com.t.s.eyecloud.auth.remote;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.CountDownLatch;

/**
 * Desc:<一句话功能简述>
 * Info:<功能详细描述>
 * @since [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * Date:2019/12/27 15:40
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.t.s.eyecloud"})
@MapperScan(basePackages = {"com.t.s.eyecloud.mapper"})
public class AuthRemoteApplication {

    private static final Logger logger = LoggerFactory.getLogger(AuthRemoteApplication.class);

    private static CountDownLatch countDownLatch = new CountDownLatch(1);


    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AuthRemoteApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
        try {
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    logger.info("===========AuthRemoteApplication关闭成功=============");
                }
            }));
            logger.info("====================================================");
            logger.info("===========AuthRemoteApplication启动成功=============");
            logger.info("====================================================");
            countDownLatch.await();
        } catch (Exception e) {
            logger.error("AuthRemoteApplication Start Failed!!!");
            System.exit(1);
        }
    }
}
