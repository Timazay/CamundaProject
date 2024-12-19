package com.example.camundaproject.delegate.parent;

import com.example.camundaproject.entity.Task;
import com.example.camundaproject.repository.TaskRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bDSave")
public class BDSave implements JavaDelegate {
    @Autowired
    private TaskRepository repository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String title = (String) delegateExecution.getVariable("title");
        String describe = (String) delegateExecution.getVariable("description");
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(describe);
        repository.save(task);
    }
}
