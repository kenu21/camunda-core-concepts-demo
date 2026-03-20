package com.keniu;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MyDelegate implements JavaDelegate {
    private static Random random = new Random(47);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setVariable("myVariable", random.nextInt());
        System.out.println("My random number is: " + delegateExecution.getVariable("myVariable"));
    }
}
