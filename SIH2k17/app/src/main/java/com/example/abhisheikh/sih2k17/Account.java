package com.example.abhisheikh.sih2k17;

/**
 * Created by abhisheikh on 23/3/17.
 */

public class Account {
    private String date;
    private String description;

    public Account(String date, String description) {
        this.date = date;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
