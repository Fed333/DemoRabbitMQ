package com.romanko.rapid.clothes.manufacturer.adidas.entity;

import lombok.Data;

@Data
public class ProvideClothesItemRequest {

    private ClothesCategory category;

    private String clothesItem;

    private String size;

    private Integer numberOfItems;
}