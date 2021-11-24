package ru.rsreu.javaeewebapp.commands.outputs;

import ru.rsreu.javaeewebapp.models.Course;

import java.io.Serializable;
import java.util.List;

public class ShowAllCoursesOutput implements Serializable {

    List<Course> allCourses;

    public List<Course> getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(List<Course> allCourses) {
        this.allCourses = allCourses;
    }

}
