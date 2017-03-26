package com.example.abhisheikh.sihapp.other;

/**
 * Created by abhisheikh on 26/3/17.
 */

public class Contact {
    private String name;
    private String position;
    private String mobileNumber;

    public Contact(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public Contact(String name, String position, String mobileNumber) {
        this.name = name;
        this.position = position;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
