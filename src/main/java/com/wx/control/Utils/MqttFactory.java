package com.wx.control.Utils;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class MqttFactory {

    private static MqttClient client;

    /**
     *   获取客户端实例
     *   单例模式, 存在则返回, 不存在则初始化
     */
    public static MqttClient getInstance() {
        if (client == null) {
            init();
        }
        return client;
    }

    /**
     *   初始化客户端
     */
    public static void init() {
        try {
            client = new MqttClient("tcp://101.35.241.96:1883", "client-" + System.currentTimeMillis());
            // MQTT配置对象
            MqttConnectOptions options = new MqttConnectOptions();
            // 设置自动重连, 其它具体参数可以查看MqttConnectOptions
            options.setAutomaticReconnect(true);
            if (!client.isConnected()) {
                client.connect(options);
            }
        } catch (MqttException e) {
            LOGGER.warning(String.format("MQTT: 连接消息服务器[%s]失败", "101.35.241.96"));
        }
    }

}