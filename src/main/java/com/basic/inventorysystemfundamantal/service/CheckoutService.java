package com.basic.inventorysystemfundamantal.service;

/*
 * Created by Ankul on 07-09-2026 16:19
 */


import com.basic.inventorysystemfundamantal.config.LoggerConfig;
import com.basic.inventorysystemfundamantal.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CheckoutService {

    private static final Logger logger = LoggerConfig.getLogger(CheckoutService.class.getName());

    private AddItemService addItemService;

    public CheckoutService(AddItemService addItemService) {

        this.addItemService = addItemService;
    }

    public OrderResult checkout(ShoppingCart cart) {

        List<CartItem> successfulItems = new ArrayList();
        double total = 0;
        for (CartItem ci : cart.getCartItems()) {
            Item item = ci.getItem();
            if (item.getQuantity() >= ci.getQuantity()) {

                int remQuantity = ci.getQuantity() - item.getQuantity();
                item.setQuantity(remQuantity);
                //calculate the total price for cart item
                total = total + ci.getQuantity() * item.getPrice();
                successfulItems.add(ci);

            } else {
                System.out.println("Not enough stock for " + item.getName());
                logger.warning("Order failed: Not enough stock for " + item.getName() +
                        " | Requested: " + ci.getQuantity() + " | Available: " + item.getQuantity());
            }

        }
        if (!successfulItems.isEmpty()) {
            //generate the invoice
            CartInvoice cartInvoice = new CartInvoice(successfulItems, total, "Checkout successful!");
            return new OrderResult(true, cartInvoice, "Success");

        } else {
            return new OrderResult(false, (CartInvoice) null, "Checkout failed: No items placed.");
        }


    }

}
