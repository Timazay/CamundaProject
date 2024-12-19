package com.example.camundaproject.delegate.parent;

import com.example.camundaproject.entity.Child;
import com.example.camundaproject.entity.Task;
import com.example.camundaproject.repository.ChildRepository;
import com.example.camundaproject.repository.TaskRepository;
import com.example.camundaproject.service.SendMessengerService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQSend implements JavaDelegate {
    @Autowired
    private ChildRepository repository;
    @Autowired
    private SendMessengerService service;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable("childName");
        String title = (String) delegateExecution.getVariable("title");
        String description = (String) delegateExecution.getVariable("description");
        Child child = repository.findChildByUsername(username);

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        service.sendMsg(child.getId(), task);

    }
}
