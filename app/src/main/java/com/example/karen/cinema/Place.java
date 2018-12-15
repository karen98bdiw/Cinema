package com.example.karen.cinema;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Place implements Serializable{

    public static  List<User> users;

    static {
        users = new ArrayList<>();
        }



    private int reserverId;
    private int numberOfRow;
    private int numberOfColl;
    private boolean isReserved;
    private int placePrice;

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

    public void setReserverId(int reserverId) {
        this.reserverId = reserverId;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public boolean isReserved() {
        return isReserved;
    }
}
