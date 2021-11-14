package ru.rsreu.javaeewebapp.models;

import ru.rsreu.javaeewebapp.models.enums.Attendance;
import ru.rsreu.javaeewebapp.models.enums.FinalGrade;
import ru.rsreu.javaeewebapp.models.enums.Grade;
import ru.rsreu.javaeewebapp.util.ColumnLink;

import java.sql.Date;

public class Progress {

    @ColumnLink("last_name")
    private String lastName;
    @ColumnLink("first_name")
    private String firstName;
    @ColumnLink("middle_name")
    private String middleName;
    @ColumnLink("final_grade")
    private FinalGrade finalGrade;
    @ColumnLink("course_date") //"dates.course_date" in query?
    private Date date;
    @ColumnLink("grade")
    private Grade grade;
    @ColumnLink("attendance")
    private Attendance attendance;

    public Progress() {

    }
    public Progress(String lastName, String firstName,
                    String middleName, FinalGrade finalGrade,
                    Date date, Grade grade, Attendance attendance) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.finalGrade = finalGrade;
        this.date = date;
        this.grade = grade;
        this.attendance = attendance;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public FinalGrade getFinalGrade() {
        return this.finalGrade;
    }

    public Date getDate() {
        return this.date;
    }

    public int getGrade() {
        return this.grade.getGrade();
    }

    public int getAttendance() {
        return this.attendance.getAttendance();
    }

}
