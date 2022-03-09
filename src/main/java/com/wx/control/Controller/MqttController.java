package com.wx.control.Controller;


import com.wx.control.Utils.MessageListener;
import com.wx.control.Utils.MqttUtil;
import com.wx.control.Utils.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MqttController {

    @RequestMapping("mqtt/send")
    public void getMessage(){
//        MqttUtil.subscribe("test",new MessageListener());
        MqttUtil.send("test","hello");
    }


}

