package com.example.camundaproject.delegate.parent;

import com.example.camundaproject.entity.Child;
import com.example.camundaproject.entity.Parent;
import com.example.camundaproject.repository.ChildRepository;
import com.example.camundaproject.service.ParentService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChildSearch implements JavaDelegate {
    @Autowired
    private ChildRepository repository;
    @Autowired
    private ParentService parentService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable("username");
        String childName = (String) delegateExecution.getVariable("childName");
        Parent parent = parentService.parentFindByUsername(username);
        Child child = repository.findChildByUsername(childName);

        if (child == null || !parent.getFamily().getUniqueName().equals(child.getFamily().getUniqueName())) {
            throw new Exception("There is no such child in family");
        }
    }
}
