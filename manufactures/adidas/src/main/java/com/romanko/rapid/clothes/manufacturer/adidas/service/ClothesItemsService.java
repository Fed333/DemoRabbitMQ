package com.romanko.rapid.clothes.manufacturer.adidas.service;

import com.romanko.rapid.clothes.manufacturer.adidas.entity.ClothesItem;
import com.romanko.rapid.clothes.manufacturer.adidas.entity.ProvideClothesItemRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClothesItemsService {

    private final MakeClothesItemsService makeClothesItemsService;

    private final SendClothesItemsService sendClothesItemsService;

    public void manufactureAndSendClothes(String distributorRoutingKey, ProvideClothesItemRequest request) {
        List<ClothesItem> clothes = makeClothesItemsService.manufactureClothes(request);
        log.info("Manufactured {} of {} cloth items", request.getNumberOfItems(), request.getClothesItem());

        log.info("Start sending clothes to {}", distributorRoutingKey);
        sendClothesItemsService.sendClothesItems(distributorRoutingKey, clothes);
        log.info("End sending clothes to {}", distributorRoutingKey);
    }

}
