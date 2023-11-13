package com.romanko.rapid.clothes.manufacturer.adidas.controller;

import com.romanko.rapid.clothes.manufacturer.adidas.entity.ProvideClothesItemRequest;
import com.romanko.rapid.clothes.manufacturer.adidas.service.ClothesItemsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProviderController {

    private final ClothesItemsService clothesItemsService;

    @PostMapping("/send/to/{routing_key}")
    public ResponseEntity<String> provide(@PathVariable("routing_key") String routing,
                                          @RequestBody ProvideClothesItemRequest clothesItemMessage) {
        clothesItemsService.manufactureAndSendClothes(routing, clothesItemMessage);
        return ResponseEntity.ok("Successfully provided " + routing + " queue with " + clothesItemMessage.getNumberOfItems() + " " + clothesItemMessage.getClothesItem() + " items");
    }
}
