package com.example.camundaproject.delegate;

import com.example.camundaproject.entity.Child;
import com.example.camundaproject.repository.ChildRepository;
import com.example.camundaproject.service.SendMessengerService;
import com.example.camundaproject.util.ConfigProvider;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MQSend implements JavaDelegate {
    @Autowired
    private ChildRepository repository;
    @Autowired
    private SendMessengerService service;


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable("childName");
        String title = (String) delegateExecution.getVariable("title");
        String description = (String) delegateExecution.getVariable("description");
        Child child = repository.findByUsername(username);

        service.sendMsg(child.getId(), title, description);

    }
}
