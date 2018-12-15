package com.example.karen.cinema;

import android.graphics.Point;

public class User {

    private  String name;
    private  String username;
    private  int[] reservedPlaces;
    private int userId;

    public User(String name, String username,int placeRow,int placeCol,int userId) {
        this.name = name;
        this.username = username;
        this.reservedPlaces = new int[]{placeRow,placeCol};
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
}
