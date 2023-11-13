package com.romanko.rapid.clothes.manufacturer.adidas.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProviderController {

    private final AmqpTemplate template;

    @PostMapping("/send/to/{routing_key}")
    public ResponseEntity<String> provide(@PathVariable("routing_key") String routing,
                                          @RequestBody String clothesItemMessage) {
        template.convertAndSend(routing, clothesItemMessage);
        return ResponseEntity.ok("Success provided " + routing + " queue with: " + clothesItemMessage);
    }
}
