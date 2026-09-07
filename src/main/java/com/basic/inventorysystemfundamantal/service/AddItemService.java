package com.basic.inventorysystemfundamantal.service;

/* author :  Ankul Deshpande */

import com.basic.inventorysystemfundamantal.entity.Item;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

public class AddItemService {

    private Map<Integer, Item> inventory = new HashMap<>();

    // Add item
    public void addItem(Item item) {
        inventory.put(item.getId(), item);
    }

    // Display all items
    public void displayInventory() {
        inventory.values().forEach(System.out::println);
    }

    // Get total value of inventory
    public void getTotalValue() {
        Double totalQuantity = inventory.values().stream().mapToDouble(i -> i.getQuantity()).sum();
        System.out.println("totalQuantity " + totalQuantity);
        Double totalQuantityPrice = inventory.values().stream()
                .mapToDouble(i -> i.getQuantity() * i.getPrice()).sum();
        System.out.println("totalQuantityPrice " + totalQuantityPrice);

    }

    public Map<Integer, Item> getInventory() {
        return inventory;
    }

    public void setInventory(Map<Integer, Item> inventory) {
        this.inventory = inventory;
    }

}
