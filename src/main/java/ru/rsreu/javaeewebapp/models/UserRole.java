package ru.rsreu.javaeewebapp.models;

import ru.rsreu.javaeewebapp.models.enums.Role;

public class UserRole {


    private int id;
    private UserName name;
    private Role role;

    public UserRole(int id, UserName name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name.getFullName();
    }

    public int getRole() {
        return this.role.getRoleId();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(UserName name) {
        this.name = name;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
