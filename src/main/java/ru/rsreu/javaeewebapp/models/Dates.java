package ru.rsreu.javaeewebapp.models;

import java.sql.Date;

import static ru.rsreu.javaeewebapp.util.DateStringConverter.convertDateToStudentString;

public class Dates {

    private int id;
    private Date date;
    private String stringDate;

    public Dates(int id, Date date) {
        this.id = id;
        this.date = date;
        this.stringDate = convertDateToStudentString(date);
    }

    public int getId() {
        return this.id;
    }

    public String getDate() {
        return convertDateToStudentString(this.date);
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
