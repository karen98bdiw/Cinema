package com.example.karen.cinema;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Seans implements Serializable {


    private Date seansDate;
    private Hall hall;
    private String price;

    public Seans(Hall hall, Date date, String price) {
        this.hall = hall;
        this.seansDate = date;
        this.price = price;
    }

    public Date getSeansDate() {
        return seansDate;
    }

    public Hall getHall() {
        return hall;
    }

    public String getPrice() {
        return price;
    }
}
