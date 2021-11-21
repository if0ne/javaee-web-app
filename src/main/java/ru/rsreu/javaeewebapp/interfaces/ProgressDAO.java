package ru.rsreu.javaeewebapp.interfaces;

import ru.rsreu.javaeewebapp.models.Progress;

import java.util.List;

public interface ProgressDAO {
    //change database
    //update student progress
    void updateStudentProgress(int studentId, int courseId, int dateId, int attendance, int grade);
    //update student final grade
    void updateFinalGrade(int studentId, int courseId, int finalGrade);
}
