package ru.rsreu.javaeewebapp.models;

import ru.rsreu.javaeewebapp.models.enums.Role;

public class User {

    private int id;
    private Role role;
    private UserName name;
    private boolean status;

    public User(int id, Role role, UserName name, boolean status) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public int getRole() {
        return this.role.getRoleId();
    }

    public String getName() {
        return this.name.getFullName();
    }

    public String getFirstName() { return this.name.getFirstName(); }
    public String getLastName() { return this.name.getLastName(); }

    public boolean getStatus() {
        return this.status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setName(UserName name) {
        this.name = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
