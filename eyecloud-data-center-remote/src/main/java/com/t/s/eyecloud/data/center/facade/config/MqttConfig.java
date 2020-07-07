package com.t.s.eyecloud.data.center.facade.config;

import com.t.s.eyecloud.data.center.facade.service.AReceiveServiceImpl;
import com.t.s.eyecloud.data.center.facade.service.BReceiveServiceImpl;
import com.t.s.eyecloud.data.center.facade.service.IMqttReceiveService;
import com.t.s.eyecloud.data.center.facade.service.TestReceiveServiceImpl;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
@Component
@Order(1)
@IntegrationComponentScan
public class MqttConfig {

    private static final Logger logger = LoggerFactory.getLogger(MqttConfig.class);

    /**
     * 订阅的bean名称
     */
    public static final String CHANNEL_NAME_IN = "mqttInboundChannel";
    /**
     * 发布的bean名称
     */
    public static final String CHANNEL_NAME_OUT = "mqttOutboundChannel";

    @Value("${spring.mqtt.url}")
    private String hostUrl;

    @Value("${spring.mqtt.client.id}")
    private String clientId;

    @Value("${spring.mqtt.default.topic}")
    private String defaultTopic;


    @Value("${spring.mqtt.username}")
    private String userName;

    @Value("${spring.mqtt.password}")
    private String passWord;

    @Value("${spring.mqtt.keepAliveInterval}")
    private int keepAliveInterval;

    MqttPahoMessageDrivenChannelAdapter adapter = null;

    Map<String, IMqttReceiveService> localMap = new ConcurrentHashMap<>();

    @Bean
    public MqttConnectOptions getMqttConnectOptions() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName(userName);
        mqttConnectOptions.setPassword(passWord.toCharArray());
        mqttConnectOptions.setServerURIs(new String[]{hostUrl});
        mqttConnectOptions.setKeepAliveInterval(keepAliveInterval);
        return mqttConnectOptions;
    }

    @Bean
    public MqttPahoClientFactory mqttClientFactory(MqttConnectOptions mqttConnectOptions) {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(mqttConnectOptions);
        return factory;
    }

    /**
     * 发送通道
     *
     * @return
     */
    @Bean(name = CHANNEL_NAME_OUT)
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = CHANNEL_NAME_OUT)
    public MessageHandler MqttOutbound(MqttPahoClientFactory mqttPahoClientFactory) {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(clientId + "_producer", mqttPahoClientFactory);
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic(defaultTopic);
        return messageHandler;
    }

    /**
     * 接收通道
     *
     * @return
     */
    @Bean(name = CHANNEL_NAME_IN)
    public SubscribableChannel mqttInboundChannel() {
        return new DirectChannel();
    }

    @Bean
    public MqttPahoMessageDrivenChannelAdapter adapter(MqttPahoClientFactory mqttPahoClientFactory) {
        this.adapter = new MqttPahoMessageDrivenChannelAdapter(clientId + "_consumer", mqttPahoClientFactory, "topic");
        return this.adapter;
    }

    /**
     * 配置client,监听的topic
     *
     * @return
     */
    @Bean
    public MessageProducer inbound(MqttPahoMessageDrivenChannelAdapter adapter, @Qualifier(CHANNEL_NAME_IN) SubscribableChannel subscribableChannel) {
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(subscribableChannel);
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = CHANNEL_NAME_IN)
    public MessageHandler handlerTest() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                try {
                    String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString();
                    IMqttReceiveService iMqttReceiveService = localMap.get(topic);
                    if (iMqttReceiveService != null) {
                        iMqttReceiveService.handlerMqttMessage(topic, message.getPayload().toString());
                    }
                } catch (MessagingException ex) {
                    logger.error("error {}, {}", ex.getMessage(), ex);
                }
            }
        };
    }

    private void init() {
        this.addListenTopic("test", new TestReceiveServiceImpl());
        this.addListenTopic("test-a", new AReceiveServiceImpl());
        this.addListenTopic("test-b", new BReceiveServiceImpl());
    }


    /**
     * 注册 Topic
     *
     * @param topic
     * @param iMqttReceiveService
     */
    public void addListenTopic(String topic, IMqttReceiveService iMqttReceiveService) {
        localMap.put(topic, iMqttReceiveService);
        adapter.addTopic(topic);
        adapter.removeTopic();
    }

    /**
     * 移除监听
     *
     * @param topic
     */
    public void removeListenTopic(String topic) {
        localMap.remove(topic);
        adapter.removeTopic(topic);
    }

}