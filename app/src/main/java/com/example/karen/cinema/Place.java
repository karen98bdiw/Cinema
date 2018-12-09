package com.example.karen.cinema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Place implements Serializable{

    public static  List<User> users;

    static {
        users = new ArrayList<>();
        }

    private int numberOfRow;
    private int numberOfColl;

    public Place(int numberOfRow, int numberOfColl) {
        this.numberOfRow = numberOfRow;
        this.numberOfColl = numberOfColl;
    }

    public void soldThisPlace(User user){
        users.add(user);
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    public int getNumberOfColl() {
        return numberOfColl;
    }
}
