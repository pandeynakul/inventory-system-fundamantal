package com.basic.inventorysystemfundamantal.service;

/* author :  Ankul Deshpande */

import com.basic.inventorysystemfundamantal.config.LoggerConfig;
import com.basic.inventorysystemfundamantal.entity.Invoice;
import com.basic.inventorysystemfundamantal.entity.Item;
import com.basic.inventorysystemfundamantal.entity.OrderResult;

import java.util.logging.Logger;


public class PlaceOrderService {

    private static final Logger logger = LoggerConfig.getLogger(PlaceOrderService.class.getName());
    private AddItemService addItemService;
    private UpdateQuantityService updateQuantityService;

    public PlaceOrderService(AddItemService addItemService, UpdateQuantityService updateQuantityService) {
        this.addItemService = addItemService;
        this.updateQuantityService = updateQuantityService;
    }


    public OrderResult orderPlace(int id, int quantity) {

        if (addItemService.getInventory().containsKey(id)) {
            //perform the operation
            //check whether quantity are present or not
            Item item = addItemService.getInventory().get(id);
            if (item.getQuantity() >= quantity) {
                //start the order placing-
                int rQuantity = item.getQuantity() - quantity;
                item.setQuantity(rQuantity);
                //calculate the price
                double totalPrice = quantity * item.getPrice();
                updateQuantityService.updateQuantityService(id, rQuantity);
                //generate invoice
                Invoice invoice = new Invoice(item.getName(), quantity,
                        item.getPrice(), totalPrice, "##Order placed successfully!");
                logger.info("Order successful: " + quantity + " x " + item.getName() +
                        " | Remaining: " + item.getQuantity());
                return new OrderResult(true, invoice, "Success");


            } else {
                logger.warning("Order failed: Not enough stock for " + item.getName() +
                        " | Requested: " + quantity + " | Available: " + item.getQuantity());
                return new OrderResult(false, (Invoice) null,
                        "Not enough stock for " + item.getName());
            }

        } else {
            logger.severe("Order failed: Item with ID " + id + " not found!");
            return new OrderResult(false, (Invoice) null,
                    "Item not found with ID: " + id);
        }

    }
}
