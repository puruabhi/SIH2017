package com.example.abhisheikh.sihapp.other;

/**
 * Created by abhisheikh on 25/3/17.
 */

public class Fund {
    private int sought, received;
    private String used, month;

    public Fund(String month,int sought, int received, String used) {
        this.month = month;
        this.sought = sought;
        this.received = received;
        this.used = used;
    }

    public int getSought() {
        return sought;
    }

    public void setSought(int sought) {
        this.sought = sought;
    }

    public int getReceived() {
        return received;
    }

    public void setReceived(int received) {
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
