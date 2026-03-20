package com.keniu.controllers;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiveTaskController {
    private final RuntimeService runtimeService;

    public ReceiveTaskController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @PostMapping("/callback")
    public void callback(@RequestBody ResponseDto response) {
        runtimeService.createMessageCorrelation("My message")
                .processInstanceBusinessKey(response.id())
                .setVariable("status", response.status())
                .correlate();
    }
}
