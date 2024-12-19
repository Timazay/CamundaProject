package com.example.camundaproject.delegate.child;

import com.example.camundaproject.entity.Child;
import com.example.camundaproject.entity.Parent;
import com.example.camundaproject.service.ChildService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("childAccess")
public class ChildAccess implements JavaDelegate {
    @Autowired
    private ChildService service;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable("username");
        String password = (String) delegateExecution.getVariable("password");

        Child child = service.findByUsername(username);
        if (child == null || !child.getPassword().equals(password)){
            throw new  Exception("there is no such user");
        }

    }
}
