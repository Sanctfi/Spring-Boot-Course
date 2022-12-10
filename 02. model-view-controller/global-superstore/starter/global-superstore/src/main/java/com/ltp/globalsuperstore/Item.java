package com.ltp.globalsuperstore;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;

public class Item {
    private String category;
    private String name;
    private Double price;
    private Double discount;
    private Date date;
    private String id;

    public Item(String category, String name, Double price, Double discount, Date date) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.date = date;
        this.id = UUID.randomUUID().toString();
    }

    public Item() {
        this.id = UUID.randomUUID().toString();
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "{" +
            " category='" + getCategory() + "'" +
            ", name='" + getName() + "'" +
            ", price='" + getPrice() + "'" +
            ", discount='" + getDiscount() + "'" +
            ", date='" + getDate() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }

}