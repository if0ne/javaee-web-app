package ru.rsreu.javaeewebapp.models;


/**
 * Course class contains all data about the course: ID, title, description, name, surname and patronymic of the teacher,
 * as well as the status of the course (finished or active)
 * Registration status stores information for the student (whether he is registered for the course or not)
 */
public class Course {

    private int id;
    private String title;
    private String description;
    private UserName teacherName;
    private boolean registration;
    private boolean finished;

    public Course(int id, String title, String description, UserName teacherName,
                    boolean registration, boolean finished) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.teacherName = teacherName;
        this.registration = registration;
        this.finished = finished;
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
    public boolean isFinished() {
        return this.finished;
    }
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

}
