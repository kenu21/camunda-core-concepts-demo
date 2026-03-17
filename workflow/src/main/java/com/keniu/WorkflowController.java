package com.keniu;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkflowController {
    private final RuntimeService runtimeService;

    public WorkflowController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @PostMapping("/start")
    public String start() {
        runtimeService.startProcessInstanceByKey("myProcessId");
        return "started";
    }
}
