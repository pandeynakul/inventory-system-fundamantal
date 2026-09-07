package com.basic.inventorysystemfundamantal.service;

/* author :  Ankul Deshpande */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class UpdateQuantityService {


    private AddItemService addItemService;

    //via constructor or setter depends on requirement:
    public UpdateQuantityService(AddItemService addItemService) {
        this.addItemService = addItemService;
    }


    public void updateQuantityService(Integer id, Integer newQuantity) {

        if (addItemService.getInventory().containsKey(id)) {
            addItemService.getInventory().get(id).setQuantity(newQuantity);
            addItemService.displayInventory();
            addItemService.getTotalValue();

        } else {
            System.out.println("Not found the product !");
        }

    }
}
