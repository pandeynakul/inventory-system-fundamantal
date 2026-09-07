package com.basic.inventorysystemfundamantal.Controller;

/* author :  Ankul Deshpande */

import com.basic.inventorysystemfundamantal.entity.Item;
import com.basic.inventorysystemfundamantal.entity.OrderResult;
import com.basic.inventorysystemfundamantal.entity.ShoppingCart;
import com.basic.inventorysystemfundamantal.service.*;


public class AddItemController {

    AddItemService addItemService = new AddItemService();
    //with constructor:
    UpdateQuantityService updateQuantityService = new UpdateQuantityService(addItemService);
    //try to perform with setter
    DeleteItemService deleteItemService = new DeleteItemService(addItemService);

    SearchByName searchByName = new SearchByName(addItemService);
    SortByPrice sortByPrice = new SortByPrice(addItemService);
    PlaceOrderService placeOrderService = new PlaceOrderService(addItemService, updateQuantityService);
    CheckoutService checkoutService = new CheckoutService(addItemService);

    //create an Item

    public void createItem() {

        Item item1 = new Item(1, "Laptop", 5, 60000);
        Item item2 = new Item(2, "Mouse", 20, 500);
        Item item3 = new Item(3, "Keyboard", 10, 1500);
        Item item4 = new Item(4, "mobile", 1, 30000);
        Item item5 = new Item(5, "mobile", 2, 5000);
        Item item6 = new Item(6, "Keyboard", 1, 1300);

        addItemService.addItem(item1);
        addItemService.addItem(item2);
        addItemService.addItem(item3);
        addItemService.addItem(item4);
        addItemService.addItem(item5);
        addItemService.addItem(item6);

        System.out.println();
        System.out.println("*****AddItemService*****");
        addItemService.displayInventory();
        addItemService.getTotalValue();
        System.out.println();
        System.out.println("*****UpdateQuantityService*****");
        updateQuantityService.updateQuantityService(1, 8);
        System.out.println();
        System.out.println("*****deleteItemService*******");
        deleteItemService.deleteItemService(4);
        System.out.println();
        System.out.println("*****Search by Name*******");
        searchByName.searchByName("Keyboard");
        System.out.println();
        System.out.println("*****SortByPrice*******");
        sortByPrice.sortByPrice();
        System.out.println();
        System.out.println("*****Place-Order*******");
        // placeOrderService.placeOrder(2, 5);
        OrderResult orderPlace = placeOrderService.orderPlace(5, 1);
        System.out.println(orderPlace);
        if (orderPlace.isSuccess()) {
            System.out.println(orderPlace.getInvoice());
        } else {
            System.out.println(orderPlace.getMessage());
        }
        System.out.println();
        System.out.println("*****checkout-service*******");
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(item1, 2);
        cart.addItem(item2, 5);
        cart.addItem(item3, 1);
        OrderResult cartOrderPlaced = checkoutService.checkout(cart);
        System.out.println(cartOrderPlaced);
        if (orderPlace.isSuccess()) {
            System.out.println(cartOrderPlaced.getInvoice());
        } else {
            System.out.println(orderPlace.getMessage());
        }

    }
}
