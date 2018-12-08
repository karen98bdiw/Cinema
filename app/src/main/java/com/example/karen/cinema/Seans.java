package com.example.karen.cinema;

import java.util.Date;
import java.util.List;

public class Seans {

   private Date seansDate;
   private Hall hall;
   private int price;

    public Seans(Hall hall, Date date,int price) {
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

    public int getPrice() {
        return price;
    }
}
