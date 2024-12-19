package com.example.camundaproject.delegate.child;

import com.example.camundaproject.entity.Task;
import com.example.camundaproject.repository.TaskRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("completeCheck")
public class CompleteCheck implements JavaDelegate {
    @Autowired
    private TaskRepository repository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String title = (String) delegateExecution.getVariable("title");
        Task task = repository.findTaskByTitle(title);

        if (task.isComplete()){
            throw new Exception("task already completed!");
        }


    }
}
