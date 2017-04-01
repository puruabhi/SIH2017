package com.example.abhisheikh.sihapp.other;

/**
 * Created by abhisheikh on 25/3/17.
 */

public class Fund {
    private float sought, received, used;
    private String useDetail, month;
    private float availableFunds;

    public Fund(String month, float sought, float received, float used, String useDetail) {
        this.sought = sought;
        this.received = received;
        this.used = used;
        this.month = month;
        this.useDetail=useDetail;
        this.availableFunds=received-used;
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

    public float getUsed() {
        return used;
    }


    public void setUsed(float used) {
        this.used = used;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public float getAvailableFunds() {
        return availableFunds;
    }

    public void setAvailableFunds(float availableFunds) {
        this.availableFunds = availableFunds;
    }

    public String getUseDetail() {
        return useDetail;
    }

    public void setUseDetail(String useDetail) {
        this.useDetail = useDetail;
    }
}
