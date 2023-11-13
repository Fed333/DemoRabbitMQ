package com.romanko.rapid.clothes.manufacturer.adidas.listener;

import com.romanko.rapid.clothes.manufacturer.adidas.entity.ProvideClothesItemRequest;
import com.romanko.rapid.clothes.manufacturer.adidas.service.ClothesItemsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableRabbit
@RequiredArgsConstructor
public class RequestClothesFromListener {

    private final ClothesItemsService clothesItemsService;

    @RabbitListener(queues = "request.clothes.from")
    public void processRequestClothes(@Header("x-distributor-name") String distributorName,
                                      @Header(AmqpHeaders.RECEIVED_ROUTING_KEY) String routingKey,
                                      @Payload ProvideClothesItemRequest provideClothesItemRequest) {
        log.info("Received order request from {} distributor : {}", distributorName, provideClothesItemRequest);
        log.info("AmqpHeaders.RECEIVED_ROUTING_KEY = {}", routingKey);

        String distributorRoutingKey = getDistributorRoutingKey(distributorName);
        clothesItemsService.manufactureAndSendClothes(distributorRoutingKey, provideClothesItemRequest);

        log.info("Processed clothes request from {} distributor", distributorName);
    }

    private String getDistributorRoutingKey(String distributorName) {
        return "provide.clothes.to." + distributorName;
    }
}