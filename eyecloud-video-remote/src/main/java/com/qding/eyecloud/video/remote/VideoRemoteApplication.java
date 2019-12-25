package com.qding.eyecloud.video.remote;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.qding.eyecloud"})
@MapperScan(basePackages = {"com.qding.eyecloud.mapper"})
public class VideoRemoteApplication {
    
    private static final Logger logger = LoggerFactory.getLogger(VideoRemoteApplication.class);
    
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(VideoRemoteApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
        synchronized (VideoRemoteApplication.class) {
            while (true) {
                try {
                    VideoRemoteApplication.class.wait();
                } catch (InterruptedException e) {
                    logger.error("== synchronized error:", e);
                }
            }
        }
    }
}
