package ru.rsreu.javaeewebapp.models;

import ru.rsreu.javaeewebapp.models.enums.Role;

public class UsersRoles {
    private String lastName;
    private String firstName;
    private String middleName;
    private Role role;

    public UsersRoles(String lastName, String firstName,
                      String middleName, Role role) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.role = role;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public int getRole() {
        return this.role.getRoleId();
    }
}
