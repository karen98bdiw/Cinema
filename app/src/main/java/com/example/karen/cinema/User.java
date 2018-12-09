package com.example.karen.cinema;

import android.graphics.Point;

public class User {

    private  String name;
    private  String username;
    private  int[] reservedPlaces;

    public User(String name, String username,int placeRow,int placeCol) {
        this.name = name;
        this.username = username;
        this.reservedPlaces = new int[]{placeRow,placeCol};
    }

}
