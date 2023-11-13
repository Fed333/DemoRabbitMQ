package com.romanko.rapid.clothes.distributor.intertop.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableRabbit
public class ProvideClothesToIntertopListener {

    @RabbitListener(queues = "provide.clothes.to.intertop")
    public void processProvidedClothes(String message) {
        log.info("Received provided clothes : {}", message);
    }
}
