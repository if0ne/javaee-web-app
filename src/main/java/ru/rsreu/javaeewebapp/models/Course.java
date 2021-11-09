package ru.rsreu.javaeewebapp.models;

public class Course {
    private String name;
    private String description;
    private String teacherLastName;
    private String teacherFirstName;
    private String teacherMiddleName;

    public Course(String name, String description, String teacherLastName,
                  String teacherFirstName, String teacherMiddleName) {
        this.name = name;
        this.description = description;
        this.teacherLastName = teacherLastName;
        this.teacherFirstName = teacherFirstName;
        this.teacherMiddleName = teacherMiddleName;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTeacherLastName() {
        return this.teacherLastName;
    }

    public String getTeacherFirstName() {
        return this.teacherFirstName;
    }

    public String getTeacherMiddleName() {
        return this.teacherMiddleName;
    }
}
