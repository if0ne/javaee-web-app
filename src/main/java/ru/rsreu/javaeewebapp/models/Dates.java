package ru.rsreu.javaeewebapp.models;

import ru.rsreu.javaeewebapp.util.DateStringConverter;

import java.sql.Date;

public class Dates {

    private int id;
    private Date date;
    private String stringDate;

    public Dates(int id, Date date) {
        this.id = id;
        this.date = date;
        this.stringDate = DateStringConverter.convertDateToString(date);
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

    public String getStringDate() {
        return this.stringDate;
    }

    public void setStringDate(String stringDate) {
        this.stringDate = stringDate;
    }

}
