package ru.rsreu.javaeewebapp.models;

import ru.rsreu.javaeewebapp.models.enums.Role;

import java.io.Serializable;

/**
 * class containing user information for administrator
 */
public class UserRole implements Serializable {

    private int id;
    private String login;
    private UserName fullName;
    private UserName name;
    private Role role;

    public UserRole(int id, String login, UserName name, Role role) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.fullName = name;
        this.role = role;
    }

    public int getId() {
        return this.id;
    }

    public String getLogin() {
        return this.login;
    }

    public String getName() {
        return this.name.getLastAndFirstName();
    }
    public String getFullName() { return this.fullName.getFullName(); }

    public String getRole() {
        return this.role.getLocale();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setFullName(UserName fullName) {
        this.fullName = fullName;
    }
    public void setName(UserName name) {
        this.name = name;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
