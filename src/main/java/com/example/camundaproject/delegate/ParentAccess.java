package com.example.camundaproject.delegate;

import com.example.camundaproject.entity.Parent;
import com.example.camundaproject.service.ParentService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ParentAccess implements JavaDelegate {

    private final ParentService parentService;

    public ParentAccess(ParentService parentService) {
        this.parentService = parentService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable("username");
        String password = (String) delegateExecution.getVariable("password");

        Parent parent = parentService.parentFindByUsername(username);
         if (parent == null || !parent.getPassword().equals(password)){
             throw new  Exception("there is no such user");
         }
    }
}
