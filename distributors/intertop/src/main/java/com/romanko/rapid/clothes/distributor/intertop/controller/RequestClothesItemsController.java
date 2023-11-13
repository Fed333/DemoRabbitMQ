package com.romanko.rapid.clothes.distributor.intertop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RequestClothesItemsController {

    private final RabbitTemplate template;

    @PostMapping("/request/clothes")
    public ResponseEntity<?> requestClothes(@RequestBody String messageRequest) {
        log.info("Request clothes {}", messageRequest);

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("x-distributor-name", "intertop");

        Message message = template.getMessageConverter().toMessage(messageRequest, messageProperties);
        messageProperties.setContentType("json");
        template.convertAndSend("request.clothes.from", message);

        return ResponseEntity.ok("Requested some clothes.");
    }
}
