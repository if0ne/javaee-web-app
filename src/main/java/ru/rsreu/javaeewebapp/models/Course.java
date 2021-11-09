package ru.rsreu.javaeewebapp.models;

import ru.rsreu.javaeewebapp.util.ColumnLink;

public class Course {

    @ColumnLink("name")
    private String name;
    @ColumnLink("description")
    private String description;
    @ColumnLink("last_name")
    private String teacherLastName;
    @ColumnLink("first_name")
    private String teacherFirstName;
    @ColumnLink("middle_name")
    private String teacherMiddleName;

    public Course() {

    }
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
