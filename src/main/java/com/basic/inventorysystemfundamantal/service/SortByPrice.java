package com.basic.inventorysystemfundamantal.service;

/* author :  Ankul Deshpande */

import com.basic.inventorysystemfundamantal.entity.Item;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortByPrice {
    private AddItemService addItemService;

    public SortByPrice(AddItemService addItemService) {
        this.addItemService = addItemService;
    }

    public void sortByPrice() {
        List<Item> itemPriceLists = addItemService.getInventory().values().stream().
                sorted(Comparator.comparingDouble(Item::getPrice)).collect(Collectors.toList());
        itemPriceLists.forEach(System.out::println);
    }

}
