package com.example.camundaproject.delegate.child;

import com.example.camundaproject.entity.Task;
import com.example.camundaproject.repository.TaskRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("reportSet")
public class ReportSet implements JavaDelegate {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String title = (String) delegateExecution.getVariable("title");
        String report = (String) delegateExecution.getVariable("report");

        Task task = taskRepository.findTaskByTitle(title);
        task.setReport(report);
        taskRepository.save(task);
    }
}
