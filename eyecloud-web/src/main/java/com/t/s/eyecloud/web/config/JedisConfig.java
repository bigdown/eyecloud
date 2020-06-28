package com.t.s.eyecloud.web.config;

import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
public class JedisConfig {

    public static String SPRING_REDIS_DATABASE;
    public static String SPRING_REDIS_HOST;
    public static String SPRING_REDIS_PORT;
    public static String SPRING_REDIS_PASSWORD;
    public static String SPRING_REDIS_TIMEOUT;
    public static String SPRING_REDIS_JEDIS_POOL_MAXACTIVE;
    public static String SPRING_REDIS_JEDIS_POOL_MAXWAIT;
    public static String SPRING_REDIS_JEDIS_POOL_MAXIDLE;
    public static String SPRING_REDIS_JEDIS_POOL_MINIDLE;

    static {
        try {
            String envFile = "common.properties";
            Properties envProps = new Properties();
            envProps.load(new InputStreamReader(
                    JedisConfig.class.getClassLoader().getResourceAsStream(envFile), "UTF-8"));
            Field[] fields = JedisConfig.class.getFields();
            for (Field field : fields) {
                field.set(null, envProps.getProperty(field.getName().replace("_", ".").toLowerCase()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
