package ru.rsreu.javaeewebapp.models;

public class Course {

    private int id;
    private String title;
    private String description;
    private UserName teacherName;
    //determines whether a student is registered for the course or not
    private boolean registration;

    public Course(int id, String title, String description, UserName teacherName, boolean registration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.teacherName = teacherName;
        this.registration = registration;
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

    public boolean isRegistration() {
        return this.registration;
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

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }
}
