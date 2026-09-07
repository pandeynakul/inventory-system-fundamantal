package com.basic.inventorysystemfundamantal.entity;

/*
 * Created by Ankul on 04-09-2026 15:59
 */


import java.time.LocalDateTime;

public class Invoice {

    private String itemName;
    private int orderedQty;
    private double unitPrice;
    private double totalCost;
    private LocalDateTime timestamp;
    private String message;

    public Invoice(String itemName, int orderedQty, double unitPrice,
                   double totalCost, String message) {
        this.itemName = itemName;
        this.orderedQty = orderedQty;
        this.unitPrice = unitPrice;
        this.totalCost = totalCost;
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "\nitemName='" + itemName + '\'' +
                ", \norderedQty=" + orderedQty +
                ", \nunitPrice=" + unitPrice +
                ", \ntotalCost=" + totalCost +
                ", \ntimestamp=" + timestamp +
                ", \nmessage='" + message + '\'' +
                '}';
    }

}
