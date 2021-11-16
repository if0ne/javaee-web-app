package ru.rsreu.javaeewebapp.models;

import ru.rsreu.javaeewebapp.util.ColumnLink;

import java.sql.Date;

public class TeacherCourse {

    private int id;
    private String title;
    private int studentsNumber;
    private Date nextClassDate;

    public TeacherCourse(int id, String title, int studentsNumber, Date nextClassDate) {
        this.id = id;
        this.title = title;
        this.studentsNumber = studentsNumber;
        this.nextClassDate = nextClassDate;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return  this.title;
    }

    public int getStudentsNumber() {
        return this.studentsNumber;
    }

    public Date getNextClassDate() {
        return this.nextClassDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStudentsNumber(int studentsNumber) {
        this.studentsNumber = studentsNumber;
    }

    public void setNextClassDate(Date nextClassDate) {
        this.nextClassDate = nextClassDate;
    }
}
