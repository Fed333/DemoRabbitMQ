package com.romanko.rapid.clothes.manufacturer.adidas.service;

import com.romanko.rapid.clothes.manufacturer.adidas.entity.ClothesItem;
import com.romanko.rapid.clothes.manufacturer.adidas.entity.ProvideClothesItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MakeClothesItemsService {

    private final Map<String, Double> clothItemPrices;

    public List<ClothesItem> manufactureClothes(ProvideClothesItemRequest request) {
        Integer count = request.getNumberOfItems();

        return Stream.generate(() -> manufactureClothItem(request))
                .limit(count)
                .collect(Collectors.toList());
    }

    public ClothesItem manufactureClothItem(ProvideClothesItemRequest request) {
        ClothesItem clothItem = new ClothesItem();
        clothItem.setCategory(request.getCategory());
        clothItem.setClothItem(request.getClothesItem());
        clothItem.setManufacturer("Adidas");
        clothItem.setSize(request.getSize());
        clothItem.setPrice(clothItemPrices.get(request.getClothesItem()));
        return  clothItem;
    }

}
