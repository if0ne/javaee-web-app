package ru.rsreu.javaeewebapp.models;

import ru.rsreu.javaeewebapp.util.ColumnLink;

public class Course {

    private int id;
    private String title;
    private String description;
    private UserName teacherName;

    public Course(int id, String title, String description, UserName teacherName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.teacherName = teacherName;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTeacherName() {
        return this.teacherName.getFullName();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTeacherName(UserName teacherName) {
        this.teacherName = teacherName;
    }
}
