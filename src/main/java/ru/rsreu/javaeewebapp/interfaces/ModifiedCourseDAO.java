package ru.rsreu.javaeewebapp.interfaces;

import java.sql.Date;
import java.util.List;

public interface ModifiedCourseDAO {

    /**
     * writes a new course to the database
     * add new records to the tables "courses" and "dates"
     * @param teacherId - user id
     * @param title - title of new course
     * @param description - description of new course
     * @param dates - dates of classes
     */
    void createCourse(int teacherId, String title, String description, List<Date> dates);

    /**
     * registers a student for the course (adds new records to the tables "user_courses", "final grade", "classes")
     * @param studentId
     * @param courseId
     */
    void signUpToCourse(int studentId, int courseId);

    /**
     * drop out a student with studentId as user id from course with courseId
     * delete records from the user_courses, classes and final_grade tables
     * @param studentId student id
     * @param courseId course id
     */
    void dropOutStudent(int studentId, int courseId);
}
