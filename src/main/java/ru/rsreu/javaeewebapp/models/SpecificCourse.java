package ru.rsreu.javaeewebapp.models;

import java.util.List;

public class SpecificCourse {

    private int id;
    private UserName teacher;
    private String description;
    private List<Dates> dates;
    private List<Student> students;

    public SpecificCourse(int id, UserName teacher, String description,
                          List<Dates> dates, List<Student> students) {
        this.id = id;
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
}
