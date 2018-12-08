package com.example.karen.cinema;

import java.io.Serializable;

public class Place implements Serializable{
    private int numberOfRow;
    private int numberOfColl;

    public Place(int numberOfRow, int numberOfColl) {
        this.numberOfRow = numberOfRow;
        this.numberOfColl = numberOfColl;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    public int getNumberOfColl() {
        return numberOfColl;
    }
}
