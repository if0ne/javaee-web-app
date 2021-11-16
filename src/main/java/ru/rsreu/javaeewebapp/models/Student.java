package ru.rsreu.javaeewebapp.models;

import ru.rsreu.javaeewebapp.models.enums.FinalGrade;
import ru.rsreu.javaeewebapp.util.MessageManager;
import java.util.List;

public class Student {

    private int id;
    private UserName studentName;
    private FinalGrade finalGrade;
    List<Progress> progresses;

    public Student(int id, UserName studentName,
                   FinalGrade finalGrade, List<Progress> progresses) {
        this.id = id;
        this.studentName = studentName;
        this.finalGrade = finalGrade;

    }

    public int getId() {
        return this.id;
    }

    public String getStudentName() {
        return this.studentName.getLastAndFirstName();
    }

    public String getFinalGrade() {
        return this.finalGrade.getFinalGrade();
    }

    public List<Progress> getProgresses() {
        return this.progresses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFinalGrade(FinalGrade finalGrade) {
        this.finalGrade = finalGrade;
    }

    public void setStudentName(UserName studentName) {
        this.studentName = studentName;
    }

    public void setProgresses(List<Progress> progresses) {
        this.progresses = progresses;
    }
}
