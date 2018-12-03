package com.spillz.genstore.controllers;

import com.spillz.genstore.models.data.InventoryDao;
import com.spillz.genstore.models.Inventory;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

public class InventorySearch {

    @Autowired
    private InventoryDao inventoryDao;

    public void InventorySearch(String keyword) {

        ArrayList<Inventory> searchResults = new ArrayList<>();
        for (Inventory singleItem : inventoryDao.findAll()) {
            if (singleItem.getName().toLowerCase().contains(keyword.toLowerCase()) || singleItem.getVendor().toLowerCase().contains(keyword.toLowerCase()) || singleItem.getSku().equalsIgnoreCase(keyword)) {
                searchResults.add(singleItem);
            }
        }
    }
}
