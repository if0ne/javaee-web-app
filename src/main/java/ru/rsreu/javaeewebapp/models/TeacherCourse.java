package ru.rsreu.javaeewebapp.models;

import ru.rsreu.javaeewebapp.util.ColumnLink;

import java.sql.Date;

public class TeacherCourse {

    @ColumnLink("name")
    private String name;
    @ColumnLink("count")
    private int studentsNumber;
    @ColumnLink("next_date")
    private Date nextClassDate;

    public TeacherCourse() {

    }
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
