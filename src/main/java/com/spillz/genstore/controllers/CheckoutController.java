package com.spillz.genstore.controllers;

import com.spillz.genstore.models.Inventory;
import com.spillz.genstore.models.Invoice;
import com.spillz.genstore.models.data.InventoryDao;
import com.spillz.genstore.models.data.InvoicesDao;
import com.spillz.genstore.models.forms.AddToCartForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Calendar;



@Controller
@RequestMapping(value = "general_Store/Checkout")
public class CheckoutController {

    @Autowired
    private InventoryDao inventoryDao;

    @Autowired
    private InvoicesDao invoicesDao;

    private InvoicesDao thisInvoice;

    @RequestMapping(value = "")
    public String displayregister(Model model) {
        model.addAttribute("title", "Checkout");
        System.out.println("CheckoutController");
        model.addAttribute("title", "");
        model.addAttribute("inventory", inventoryDao.findAll());
        return "general_Store/Checkout/checkout";

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processregister(Model model, @RequestParam(required = false) String keyword, @RequestParam(required = false) String search, @RequestParam(required = false) String addToOrder, @ModelAttribute AddToCartForm addToCartForm) {
        /////////////////////////////////// Search FUnction
        if (search != null && search.equals("Search Inventory")) {
            ArrayList<Inventory> searchResults = new ArrayList<>();
            for ( Inventory singleItem : inventoryDao.findAll()) {
                if (singleItem.getName().toLowerCase().contains(keyword.toLowerCase()) || singleItem.getVendor().toLowerCase().contains(keyword.toLowerCase()) || singleItem.getSku().equalsIgnoreCase(keyword) ){
                    searchResults.add(singleItem);
                }
            }
            //model.addAttribute("title", "Search: " + keyword);
            model.addAttribute("inventory", searchResults);
            return "general_Store/Checkout/checkout";
        } ///////////////////////////////// End Search FUnction^
        ///////////////////////////////// Add to cart function
        if (addToOrder != null && addToOrder.equals("Add to Cart")) {
            if (addToCartForm.getItemId().size() == addToCartForm.getQuantity().size()) {
                System.out.println("sddinv test- " + addToCartForm);
                for (int i = 0; i < addToCartForm.getItemId().size(); i++) {
                    if (addToCartForm.getQuantity().get(i) == "") {
                        System.out.println("Null skipping");
                        continue;
                    } else {
                        System.out.println("Test invoice test- ");
                    }
                }
            }
        }
                    ///////////////////////////////// End Add to cart function ^
                    model.addAttribute("title", "");
                    model.addAttribute("inventory", inventoryDao.findAll());
                    return "general_Store/Checkout/checkout";

    }


 }
