package com.example.camundaproject.listener;

import com.example.camundaproject.entity.Child;
import com.example.camundaproject.entity.Task;
import com.example.camundaproject.repository.ChildRepository;
import com.example.camundaproject.repository.TaskRepository;
import com.example.camundaproject.service.SendMessengerService;
import com.example.camundaproject.util.ConfigProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ChildTaskListener {
    @Autowired
    private TaskRepository repository;
    @Autowired
    private SendMessengerService service;

    @JmsListener(destination = ConfigProvider.CHILD_QUEUE_TASK)
    public void receiveMessage(String message) {
      Task task = service.readMsg(message);
      repository.save(task);
    }

}
