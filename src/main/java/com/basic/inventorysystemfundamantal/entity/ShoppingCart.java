package com.basic.inventorysystemfundamantal.entity;

/*
 * Created by Ankul on 07-09-2026 16:21
 */


import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> cartItems = new ArrayList<>();

    public void addItem(Item item, int qty) {
        cartItems.add(new CartItem(item, qty));
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
