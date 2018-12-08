package com.example.karen.cinema;

import java.util.Date;
import java.util.List;

public class Hall {
    private int numberOfHall;
    private int numberOfPlaces;
    private  List<Place> places;

    public Hall(int numberOfHall,int numberOfPlaces) {
        this.numberOfHall = numberOfHall;
        this.numberOfPlaces = numberOfPlaces;
    }
}
