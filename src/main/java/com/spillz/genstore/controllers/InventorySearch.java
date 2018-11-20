package com.spillz.genstore.controllers;

import com.spillz.genstore.models.data.InventoryDao;
import com.spillz.genstore.models.Inventory;
import java.util.ArrayList;

import com.spillz.genstore.models.Inventory;
import com.spillz.genstore.models.data.InventoryDao;
import com.spillz.genstore.models.forms.ReceiveInvForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;

public class InventorySearch {

    @Autowired
    private InventoryDao inventoryDao;

    public void InventorySearch(String keyword) {

        ArrayList<Inventory> searchResults = new ArrayList<>();
        for (Inventory singleItem : inventoryDao.findAll()) {
            if (singleItem.getName().toLowerCase().contains(keyword.toLowerCase()) || singleItem.getVendor().toLowerCase().contains(keyword.toLowerCase()) || singleItem.getSku().equalsIgnoreCase(keyword)) {
                searchResults.add(singleItem);
            }
          //  return searchResults;
        }
    }
}
