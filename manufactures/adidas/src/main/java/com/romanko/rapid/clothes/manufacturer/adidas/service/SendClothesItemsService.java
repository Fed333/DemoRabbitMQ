package com.romanko.rapid.clothes.manufacturer.adidas.service;

import com.romanko.rapid.clothes.manufacturer.adidas.entity.ClothesItem;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SendClothesItemsService {

    private final AmqpTemplate template;

    public void sendClothesItems(String routingKey, List<ClothesItem> clothesItems) {
        clothesItems.forEach(clothesItem -> template.convertAndSend(routingKey, clothesItem));
    }
}
