package com.example.camundaproject.service;

import com.example.camundaproject.util.ConfigProvider;
import com.typesafe.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendMessengerService {

    @Autowired
    private JmsTemplate jmsTemplate;


    public void sendMsg(long childId, String title, String description) {
        Config config = ConfigProvider.createChildDayConf(title, description);
        String msg = config.toString();
        int startIndex = msg.indexOf('{');
        int endIndex = msg.lastIndexOf('}');
        jmsTemplate.convertAndSend(ConfigProvider.CHILD_QUEUE_TASK + childId,
                msg.substring(startIndex, endIndex + 1));
    }


}
