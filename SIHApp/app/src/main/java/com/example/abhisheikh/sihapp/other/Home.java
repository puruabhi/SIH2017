package com.example.abhisheikh.sihapp.other;

/**
 * Created by abhisheikh on 24/3/17.
 */

public class Home {

    private String date;
    private String description;

    public Home(String date, String description) {
        this.date = date;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
