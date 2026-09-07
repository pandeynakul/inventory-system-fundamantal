package com.basic.inventorysystemfundamantal;


import com.basic.inventorysystemfundamantal.Controller.AddItemController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventorySystemFundamantalApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventorySystemFundamantalApplication.class, args);
        AddItemController addItemController = new AddItemController();
        addItemController.createItem();

    }

}
