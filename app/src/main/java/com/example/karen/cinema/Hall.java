package com.example.karen.cinema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hall implements Serializable {

    public static final Hall HALL_1;
    public static final Hall HALL_2;
    public static final Hall HALL_3;
    public static final Hall VIP_HALL;

    static {
        HALL_1 = new Hall("Hall 1",20,10);
        HALL_2 = new Hall("Hall 2",15,7);
        HALL_3 = new Hall("Hall 3",8,4);
        VIP_HALL = new Hall("VIP_HALL",2,4);
    }

    private String hallName;
    private int rowCount;
    private int seatCount;
    private  List<Place> places;




    public Hall(String hallName, int rowCount, int seatCount) {
        this.hallName = hallName;
        this.rowCount = rowCount;
        this.seatCount = seatCount;
        createPlaces(rowCount,seatCount);
    }

    private void createPlaces(int rowCount, int seatCount){
        places = new ArrayList<>();
        for(int i = 0;i < rowCount;i++){
            for(int j = 0;j < seatCount;j++){
                Place place = new Place(i,j);
                places.add(place);
            }
        }
    }

    public int getSeatCount() {
        return seatCount;
    }



    public String getHallName() {
        return hallName;
    }

    public List<Place> getPlaces() {
        return places;
    }
}
