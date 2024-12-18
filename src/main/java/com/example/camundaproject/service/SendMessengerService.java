package com.example.camundaproject.service;

import com.example.camundaproject.entity.Child;
import com.example.camundaproject.entity.Task;
import com.example.camundaproject.repository.ChildRepository;
import com.example.camundaproject.util.ConfigProvider;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.List;

@Service
public class SendMessengerService {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private ChildRepository childRepository;


    public void sendMsg(long childId, Task task) {
        Config config = ConfigProvider.createChildDayConf(childId, task.getTitle(), task.getDescription());
        String msg = config.toString();
        int startIndex = msg.indexOf('{');
        int endIndex = msg.lastIndexOf('}');

        String messageContent = msg.substring(startIndex, endIndex + 1);

        jmsTemplate.convertAndSend(ConfigProvider.CHILD_QUEUE_TASK, messageContent);
    }

    public Task readMsg(String msg){
        Config config = ConfigProvider.readChildDayConf(msg);
        Child child = childRepository.getOne(config.getLong("id"));
        Task task = new Task();
        task.setTitle(config.getString("title"));
        task.setDescription(config.getString("description"));
        task.setChild(child);

        return task;
    }


}
