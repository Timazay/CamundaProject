package com.example.camundaproject.delegate.parent;

import com.example.camundaproject.entity.Child;
import com.example.camundaproject.entity.Task;
import com.example.camundaproject.repository.ChildRepository;
import com.example.camundaproject.repository.TaskRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bDCheck")
public class BDCheck implements JavaDelegate {
    @Autowired
    private TaskRepository repository;
    @Autowired
    private ChildRepository childRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String title = (String) delegateExecution.getVariable("title");
        String childName = (String) delegateExecution.getVariable("childName");
        Child child = childRepository.findChildByUsername(childName);
        Task task = repository.findTaskByTitle(title);
        boolean isChildTask = false;

        for (Task t : child.getTasks()) {
            if (t.equals(task)) {
                isChildTask = true;
                break;
            }
        }

        if (!isChildTask){
            throw new Exception("There is no such child task");
        }
    }
}
