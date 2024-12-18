package com.example.camundaproject.delegate;

import com.example.camundaproject.entity.Child;
import com.example.camundaproject.entity.Task;
import com.example.camundaproject.repository.ChildRepository;
import com.example.camundaproject.repository.TaskRepository;
import com.example.camundaproject.service.SendMessengerService;
import com.example.camundaproject.util.ConfigProvider;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component("bDUpdate")
public class BDUpdate implements JavaDelegate {
    @Autowired
    private TaskRepository repository;


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String title = (String) delegateExecution.getVariable("title");
        String describe = (String) delegateExecution.getVariable("description");
        Task task = repository.findTaskByTitle(title);
        task.setDescription(describe);
        repository.save(task);

    }
}
