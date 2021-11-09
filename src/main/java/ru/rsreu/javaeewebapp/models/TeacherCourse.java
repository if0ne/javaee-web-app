package ru.rsreu.javaeewebapp.models;

import java.sql.Date;

public class TeacherCourse {
    private String name;
    private int studentsNumber;
    private Date nextClassDate;

    public TeacherCourse(String name, int studentsNumber, Date nextClassDate) {
        this.name = name;
        this.studentsNumber = studentsNumber;
        this.nextClassDate = nextClassDate;
    }

    public String getName() {
        return  this.name;
    }

    public int getStudentsNumber() {
        return this.studentsNumber;
    }

    public Date getNextClassDate() {
        return this.nextClassDate;
    }
}
