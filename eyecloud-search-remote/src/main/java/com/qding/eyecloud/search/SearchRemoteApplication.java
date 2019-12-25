package com.qding.eyecloud.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Desc:搜索服务启动类
 * Info:<功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * Date:2019年12月13日 上午9:11:42
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.qding.eyecloud"})
public class SearchRemoteApplication {
    
    private static final Logger logger = LoggerFactory.getLogger(SearchRemoteApplication.class);
    
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SearchRemoteApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
        logger.info("start dubbo service <{}> is sucessed.", SearchRemoteApplication.class);
    }
}
