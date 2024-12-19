package com.example.camundaproject.delegate.child;

import com.example.camundaproject.entity.Child;
import com.example.camundaproject.entity.Task;
import com.example.camundaproject.repository.TaskRepository;
import com.example.camundaproject.service.ChildService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("completeTask")
public class CompleteTask implements JavaDelegate {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String title = (String) delegateExecution.getVariable("title");

        Task task = taskRepository.findTaskByTitle(title);
        task.setComplete(true);
        taskRepository.save(task);
    }
}
