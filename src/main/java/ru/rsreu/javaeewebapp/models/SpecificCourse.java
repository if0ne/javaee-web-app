package ru.rsreu.javaeewebapp.models;

import java.util.List;

/**
 * it is a detailed description of the course for registered students
 * it contains title, description  and teacher name and also table of
 * students with their attendances and grades on course
 */
public class SpecificCourse {

    private int id;
    private String title;
    private UserName teacher;
    private String description;
    private List<Dates> dates;
    private List<Student> students;

    public SpecificCourse(int id, String title, UserName teacher, String description,
                          List<Dates> dates, List<Student> students) {
        this.id = id;
        this.title = title;
        this.teacher = teacher;
        this.description = description;
        this.dates = dates;
        this.students = students;
    }

    public int getId() {
        return this.id;
    }

    public String getTeacher() {
        return this.teacher.getFullName();
    }

    public String getDescription() {
        return this.description;
    }

    public List<Dates> getDates() {
        return this.dates;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeacher(UserName teacher) {
        this.teacher = teacher;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDates(List<Dates> dates) {
        this.dates = dates;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
