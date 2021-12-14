package ru.rsreu.javaeewebapp.interfaces;

import ru.rsreu.javaeewebapp.models.Course;
import ru.rsreu.javaeewebapp.models.SpecificCourse;
import ru.rsreu.javaeewebapp.models.TeacherCourse;

import java.sql.Date;
import java.util.List;

public interface CoursesDAO {

    //get information from database

    /**
     * allows get from the database a list of all courses taught by the teacher with the passed id
     * @param teacherId - user id with teacher role
     * @return all teacher courses list
     */
    List<TeacherCourse> getAllTeacherCourses(int teacherId);
    //courses list which student sign up

    /**
     * allows get from the database a list of all courses for which a student is registered with the passed id
     * @param studentId - user id with student role
     * @return student courses list
     */
    List<Course> getStudentCourses(int studentId);
    //courses list which student don't sign up

    /**
     * allows the student to get a list of all courses available in the system
     * @param studentId  - user id with student role
     * @return all courses list
     */
    List<Course> getAllStudentCourses(int studentId);
    //course information

    /**
     * allows to get more detailed information about the course, as well as the progress of all students enrolled in this course
     * @param courseId - id course, information on which you need to get
     * @return detailed information about the course
     */
    SpecificCourse getCourseInformation(int courseId);
}
