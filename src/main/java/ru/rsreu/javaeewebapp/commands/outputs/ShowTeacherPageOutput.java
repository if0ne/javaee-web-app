package ru.rsreu.javaeewebapp.commands.outputs;

import ru.rsreu.javaeewebapp.models.TeacherCourse;

import java.util.List;

public class ShowTeacherPageOutput {

    private List<TeacherCourse> courses;

    public List<TeacherCourse> getCourses() {
        return courses;
    }

    public void setCourses(List<TeacherCourse> courses) {
        this.courses = courses;
    }
}
