package com.spillz.genstore.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Invoice {


    @Id
    @GeneratedValue
    private int id;


    @ManyToMany
    private List<Inventory> itemsInCart = new ArrayList<>();

    @NotNull
    private String timeAndDate;

    public Invoice( List<Inventory> itemsInCart, String timeAndDate) {
        this.itemsInCart = itemsInCart;
        this.timeAndDate = timeAndDate;
    }
    public Invoice() {}

    public void addInvItem(Inventory invItem){ itemsInCart.add(invItem);}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Inventory> getItemsInCart() {
        return itemsInCart;
    }

    public void setItemsInCart(List<Inventory> itemsInCart) {
        this.itemsInCart = itemsInCart;
    }

    public String getTimeAndDate() {
        return timeAndDate;
    }

    public void setTimeAndDate(String timeAndDate) {
        this.timeAndDate = timeAndDate;
    }

}
