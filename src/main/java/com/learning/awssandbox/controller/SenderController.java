package com.learning.awssandbox.controller;

import com.learning.awssandbox.service.SendSQSService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/send")
public class SenderController {

    private final SendSQSService sendSQSService;

    public SenderController(SendSQSService sendSQSService) {
        this.sendSQSService = sendSQSService;
    }

    @GetMapping("/{message}")
    public void send(@PathVariable(value = "message") String message) {
        sendSQSService.send(message);
    }
}
