package ru.rsreu.javaeewebapp.models;

public class StudentStatus {

    private int id;
    private String login;
    private UserName name;
    private boolean status;

    public StudentStatus(int id, String login, UserName name, boolean status) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public String getLogin() {
        return this.login;
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

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(UserName name) {
        this.name = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
