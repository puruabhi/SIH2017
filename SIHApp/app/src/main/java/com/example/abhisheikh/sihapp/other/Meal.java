package com.example.abhisheikh.sihapp.other;

/**
 * Created by abhisheikh on 2/4/17.
 */

public class Meal {
    private float allocated, used;
    private String useDetail, week;
    private float available;
    private int children;

    public Meal(float allocated, float used, String useDetail, String week, int children) {
        this.allocated = allocated;
        this.used = used;
        this.useDetail = useDetail;
        this.week = week;
        this.available = allocated-used;
        this.children = children;
    }

    public float getAllocated() {
        return allocated;
    }

    public void setAllocated(float allocated) {
        this.allocated = allocated;
    }

    public float getUsed() {
        return used;
    }

    public void setUsed(float used) {
        this.used = used;
    }

    public String getUseDetail() {
        return useDetail;
    }

    public void setUseDetail(String useDetail) {
        this.useDetail = useDetail;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public float getAvailable() {
        return available;
    }

    public void setAvailable(float available) {
        this.available = available;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }
}
