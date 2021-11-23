package ru.rsreu.javaeewebapp.commands.outputs;

import ru.rsreu.javaeewebapp.models.Course;
import ru.rsreu.javaeewebapp.models.SpecificCourse;

import java.util.List;

public class ShowStudentDetailedCourseOutput {

    private SpecificCourse course;
    private List<Course> studentCourses;

    public SpecificCourse getCourse() {
        return course;
    }

    public void setCourse(SpecificCourse course) {
        this.course = course;
    }

    public List<Course> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<Course> studentCourses) {
        this.studentCourses = studentCourses;
    }
}
