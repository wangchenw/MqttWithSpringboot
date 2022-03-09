package com.wx.control.Utils;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class MessageListener implements IMqttMessageListener {

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        LOGGER.info(String.format("MQTT: 订阅主题[%s]发来消息[%s]", topic, new String(mqttMessage.getPayload())));
    }



}
