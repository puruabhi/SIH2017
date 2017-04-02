package com.example.abhisheikh.sihapp.other;

/**
 * Created by abhisheikh on 2/4/17.
 */

public class Suggestion {
    private String date;
    private String suggestion;

    public Suggestion(String date, String suggestion) {
        this.date = date;
        this.suggestion = suggestion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
}
