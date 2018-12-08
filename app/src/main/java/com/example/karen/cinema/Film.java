package com.example.karen.cinema;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Film {
    private String filmName;
    private String fimlImgUri;
    private List<Seans> seanses = new ArrayList<>();

    public Film(String filmName, String fimlImgUri) {
        this.filmName = filmName;
        this.fimlImgUri = fimlImgUri;
    }

    public void addSeans(Seans seans){

        seanses.add(seans);

    }

    public String getFilmName() {
        return filmName;
    }

    public String getFimlImgUri() {
        return fimlImgUri;
    }

    public List<Seans> getSeanses() {
        return seanses;
    }
}
