package ru.rsreu.javaeewebapp.models;

import ru.rsreu.javaeewebapp.models.enums.Role;
import ru.rsreu.javaeewebapp.util.ColumnLink;

public class UsersRoles {

    @ColumnLink("last_name")
    private String lastName;
    @ColumnLink("first_name")
    private String firstName;
    @ColumnLink("middle_name")
    private String middleName;
    @ColumnLink("name") //"roles.name" in query
    private Role role;

    public UsersRoles() {

    }
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
