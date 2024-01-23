package com.sheshagroups.satech.dseschool;

public class Model {
    String date,notice;

    public Model() {
    }

    public Model(String date, String notice) {
        this.date = date;
        this.notice = notice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
