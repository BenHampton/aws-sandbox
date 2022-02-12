package com.learning.awssandbox.service.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StandardQueueListener {

    @SqsListener(value = "testStandardQueue")
    public void receive(String message) {
        log.info("Message Received: " + message);
    }
}
