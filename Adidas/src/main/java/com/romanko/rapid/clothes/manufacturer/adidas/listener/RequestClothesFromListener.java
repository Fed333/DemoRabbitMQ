package com.romanko.rapid.clothes.manufacturer.adidas.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableRabbit
public class RequestClothesFromListener {

    @RabbitListener(queues = "request.clothes.from")
    public void processMyQueue(String message) {
        log.info("Received order request : {}", message);
    }
}
