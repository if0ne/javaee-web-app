package ru.rsreu.javaeewebapp.interfaces;

import ru.rsreu.javaeewebapp.models.Course;
import ru.rsreu.javaeewebapp.models.SpecificCourse;
import ru.rsreu.javaeewebapp.models.TeacherCourse;

import java.sql.Date;
import java.util.List;

public interface CoursesDAO {

    //get information from database
    //all teacher courses list
    List<TeacherCourse> getAllTeacherCourses(int teacherId);
    //courses list which student sign up
    List<Course> getStudentCourses(int studentId);
    //courses list which student don't sign up
    List<Course> getAllStudentCourses(int studentId);
    //course information
    SpecificCourse getCourseInformation(int courseId);
}
