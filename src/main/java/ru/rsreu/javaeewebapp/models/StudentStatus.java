package ru.rsreu.javaeewebapp.models;

public class StudentStatus {

    private int id;
    private UserName name;
    private boolean status;

    public StudentStatus(int id, UserName name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name.getFullName();
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(UserName name) {
        this.name = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
