package com.wx.control;

import com.wx.control.Utils.MessageListener;
import com.wx.control.Utils.MqttUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlApplication.class, args);
        MqttUtil.subscribe("test01", new MessageListener());
    }

}
