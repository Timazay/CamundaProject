package com.example.camundaproject.delegate.child;

import com.example.camundaproject.entity.Task;
import com.example.camundaproject.repository.TaskRepository;
import com.example.camundaproject.service.ChildService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("taskSearch")
public class TaskSearch implements JavaDelegate {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ChildService service;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String title = (String) delegateExecution.getVariable("title");
        String username = (String) delegateExecution.getVariable("username");
        Task task = taskRepository.findTaskByTitle(title);

        if (!task.getChild().equals(service.findByUsername(username))){
            throw new Exception("there is no such task");
        }

        delegateExecution.setVariable("report", task.getReport());
    }

}
