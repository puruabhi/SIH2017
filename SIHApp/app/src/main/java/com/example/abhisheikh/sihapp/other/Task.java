package com.example.abhisheikh.sihapp.other;

/**
 * Created by abhisheikh on 26/3/17.
 */

public class Task {
    private String name;
    private String detail;
    private String givenTo;
    private String deadline;
    private String status;

    public Task(String name, String detail, String givenTo, String deadline, String status) {
        this.name = name;
        this.detail = detail;
        this.givenTo = givenTo;
        this.deadline = deadline;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getGivenTo() {
        return givenTo;
    }

    public void setGivenTo(String givenTo) {
        this.givenTo = givenTo;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
