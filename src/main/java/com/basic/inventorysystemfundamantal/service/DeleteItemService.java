package com.basic.inventorysystemfundamantal.service;

/* author :  Ankul Deshpande */

public class DeleteItemService {

    private AddItemService addItemService;

    public DeleteItemService(AddItemService addItemService) {
        this.addItemService = addItemService;
    }


    public void deleteItemService(Integer id) {

        if (addItemService.getInventory().containsKey(id)) {
            addItemService.getInventory().remove(id);
            System.out.println("Item with id " + id + " deleted successfully!");
            addItemService.displayInventory();
            addItemService.getTotalValue();
        } else {
            System.out.println("Item not found in inventory!");
        }
    }

}
