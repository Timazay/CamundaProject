package com.example.camundaproject.delegate;

import com.example.camundaproject.entity.Child;
import com.example.camundaproject.entity.Family;
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
        String childName = (String) delegateExecution.getVariable("childName");
        String username = (String) delegateExecution.getVariable("username");
        Child child = repository.findByUsername(childName);
        delegateExecution.
        Family family = child.getFamily();
        if (child == null || !family.equals(parentService.parentFindByUsername(username).getFamily())) {
            throw new Exception("There is no such child in family");
        }
    }
}