package com.example.lab10.model;

import com.example.lab10.db.Identified;

public class YachtClub implements Identified<Integer> {
    private int id;
    private String name;
    private int price;

    public YachtClub() {}

    public YachtClub(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public YachtClub(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //region Getter and Setter
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    //endregion
}
