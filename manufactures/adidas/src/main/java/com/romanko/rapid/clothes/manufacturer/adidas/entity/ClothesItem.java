package com.romanko.rapid.clothes.manufacturer.adidas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClothesItem {

    private ClothesCategory category;

    private String clothItem;

    private String size;

    private Double price;

    private String manufacturer;
}
