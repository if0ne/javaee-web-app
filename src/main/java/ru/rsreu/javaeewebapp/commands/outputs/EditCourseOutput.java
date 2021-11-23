package ru.rsreu.javaeewebapp.commands.outputs;

import ru.rsreu.javaeewebapp.models.SpecificCourse;
import ru.rsreu.javaeewebapp.models.TeacherCourse;

import java.util.List;

public class EditCourseOutput {

    private SpecificCourse course;
    List<TeacherCourse> allCourses;

    public SpecificCourse getCourse() {
        return course;
    }

    public void setCourse(SpecificCourse course) {
        this.course = course;
    }

    public List<TeacherCourse> getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(List<TeacherCourse> allCourses) {
        this.allCourses = allCourses;
    }
}
