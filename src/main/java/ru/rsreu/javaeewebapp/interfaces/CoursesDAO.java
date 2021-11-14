package ru.rsreu.javaeewebapp.interfaces;

import ru.rsreu.javaeewebapp.models.Course;
import ru.rsreu.javaeewebapp.models.TeacherCourse;

import java.util.List;

public interface CoursesDAO {
    //список всех курсов преподавателя
    List<TeacherCourse> getAllTeacherCourses(int teacher);
    //список курсов, на которые записан студент
    List<Course> getStudentCourses(int student);
    //список всех курсов, на которые студент не записан (как-то это в один список)
    List<Course> getUnusedStudentCourses(int student);
    //информация о курсе
    Course getCourseInformation(int course);
}
