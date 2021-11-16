package ru.rsreu.javaeewebapp.models;

import java.sql.Date;

public class Dates {

    private int id;
    private Date date;

    public Dates(int id, Date date) {
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
