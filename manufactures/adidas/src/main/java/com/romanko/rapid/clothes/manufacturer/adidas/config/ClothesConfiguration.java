package com.romanko.rapid.clothes.manufacturer.adidas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ClothesConfiguration {

    @Bean
    public Map<String, Double> clothItemPrices() {
        return Map.of(
                "Sneakers", 120d,
                "Sandals", 12d,
                "Leather shoes", 180d,
                "Trousers", 100d,
                "Jeans", 80d,
                "Shorts", 50d
        );
    }

}
