package com.basic.inventorysystemfundamantal.entity;

/*
 * Created by Ankul on 04-09-2026 16:10
 */

//create Base interface for Design or go for the Generics
//according to a convenient
//or constructor is also fine TIA
public class OrderResult<T> {


    private boolean success;
    private T invoice;
    private String message;


    public OrderResult(boolean success, T invoice, String message) {
        this.success = success;
        this.invoice = invoice;
        this.message = message;
    }


    public boolean isSuccess() {
        return success;
    }

    public T getInvoice() {
        return invoice;
    }


    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "OrderResult{" +
                "success=" + success +
                ", invoice=" + invoice +
                ", message='" + message + '\'' +
                '}';
    }
}
