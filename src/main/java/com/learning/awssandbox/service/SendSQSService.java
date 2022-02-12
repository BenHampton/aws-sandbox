package com.learning.awssandbox.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SendSQSService {

    private QueueMessagingTemplate queueMessagingTemplate;

    private String endpoint;

    public SendSQSService(QueueMessagingTemplate queueMessagingTemplate,
                          @Value("${cloud.aws.end-point.uri}") String endpoint) {
        this.endpoint = endpoint;
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    public void send(String message) {
        Message payload = MessageBuilder.withPayload(message)
                .setHeader("header", "this is my header")
                .build();

        log.info("Sending Message: " + message);
        queueMessagingTemplate.send(endpoint, payload);
    }
}
