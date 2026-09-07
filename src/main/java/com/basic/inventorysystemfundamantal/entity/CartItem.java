package com.basic.inventorysystemfundamantal.entity;

/*
 * Created by Ankul on 07-09-2026 15:54
 */


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// item + quantity selected by the user.
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartItem {

    private Item item;
    private int quantity;

}
