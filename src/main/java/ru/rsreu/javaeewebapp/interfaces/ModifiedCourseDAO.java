package ru.rsreu.javaeewebapp.interfaces;

import java.sql.Date;
import java.util.List;

public interface ModifiedCourseDAO {

    //change database
    //create course
    void createCourse(int teacherId, String title, String description, List<Date> dates);
    //sign up for the course
    void signUpToCourse(int studentId, int courseId);
    //delete user from course
    void dropOutStudent(int studentId, int courseId);
}
