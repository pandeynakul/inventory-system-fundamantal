package com.basic.inventorysystemfundamantal.entity;

/* author :  Ankul Deshpande */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Item {
    private int id;
    private String name;
    private int quantity;
    private double price;

}
