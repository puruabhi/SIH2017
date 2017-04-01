package com.example.abhisheikh.sihapp.other;

/**
 * Created by abhisheikh on 25/3/17.
 */

public class Fund {
    private float sought, received;
    private String used, month;

    public Fund(String month, float sought, float received, String used) {
        this.sought = sought;
        this.received = received;
        this.used = used;
        this.month = month;
    }

    public float getSought() {
        return sought;
    }

    public void setSought(float sought) {
        this.sought = sought;
    }

    public float getReceived() {
        return received;
    }

    public void setReceived(float received) {
        this.received = received;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
