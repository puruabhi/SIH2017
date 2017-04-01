package com.example.abhisheikh.sihapp.other;

/**
 * Created by abhisheikh on 24/3/17.
 */

public class Meeting {

    private String date;
    private String developementPlan;
    private String decision;
    private String status;

    public Meeting(String date, String developementPlan, String decision, String status) {
        this.date = date;
        this.developementPlan = developementPlan;
        this.decision = decision;
        this.status=status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDevelopementPlan() {
        return developementPlan;
    }

    public void setDevelopementPlan(String developementPlan) {
        this.developementPlan = developementPlan;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getStatus(){ return status;}
    public void setStatus(String status){this.status = status;}
}
