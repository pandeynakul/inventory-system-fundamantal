package com.basic.inventorysystemfundamantal.service;

/* author :  Ankul Deshpande */

import com.basic.inventorysystemfundamantal.entity.Item;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByName {

    private AddItemService addItemService;

    public SearchByName(AddItemService addItemService) {
        this.addItemService = addItemService;
    }


    public void searchByName(String name) {
        List<Item> itemByName = addItemService.getInventory().values().stream().
                filter(i -> i.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        itemByName.forEach(System.out::println);
    }
}
