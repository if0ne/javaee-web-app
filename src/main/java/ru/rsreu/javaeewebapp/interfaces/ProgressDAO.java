package ru.rsreu.javaeewebapp.interfaces;

import ru.rsreu.javaeewebapp.models.Progress;

import java.util.List;

public interface ProgressDAO {
    /**
     * changes the grade and attendance of a student on the day of class
     * @param studentId
     * @param courseId
     * @param dateId
     * @param attendance
     * @param grade
     */
    void updateStudentProgress(int studentId, int courseId, int dateId, int attendance, int grade);

    /**
     * changes the value of the student's final grade on the course
     * @param studentId
     * @param courseId
     * @param finalGrade
     */
    void updateFinalGrade(int studentId, int courseId, int finalGrade);
}
