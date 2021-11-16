package ru.rsreu.javaeewebapp.models;

import ru.rsreu.javaeewebapp.models.enums.Attendance;
import ru.rsreu.javaeewebapp.models.enums.Grade;

public class Progress {

    private Attendance attendance;
    private Grade grade;

    public Progress(Attendance attendance, Grade grade) {
        this.attendance = attendance;
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade.getGrade();
    }

    public int getAttendance() {
        return this.attendance.getAttendance();
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
