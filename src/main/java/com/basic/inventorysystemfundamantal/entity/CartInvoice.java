package com.basic.inventorysystemfundamantal.entity;

/*
 * Created by Ankul on 08-09-2026 01:15
 */


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class CartInvoice {

    private List<CartItem> items;
    private double totalCost;
    private LocalDateTime timestamp;
    private String message;

    public CartInvoice(List<CartItem> items, double totalCost, String message) {
        this.items = items;
        this.totalCost = totalCost;
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n===== CONSOLIDATED INVOICE =====\n");
        for (CartItem ci : items) {
            sb.append(ci.getItem().getName())
                    .append(" x ").append(ci.getQuantity())
                    .append(" @ ₹").append(ci.getItem().getPrice())
                    .append(" = ₹").append(ci.getItem().getPrice() * ci.getQuantity())
                    .append("\n");
        }
        sb.append("Total Cost: ₹").append(totalCost)
                .append("\nTimestamp: ").append(timestamp)
                .append("\nMessage: ").append(message)
                .append("\n===============================\n");
        return sb.toString();
    }
}
