package ru.rsreu.javaeewebapp.models;

import ru.rsreu.javaeewebapp.util.ColumnLink;

public class StudentsStatus {

    @ColumnLink("last_name")
    private String lastName;
    @ColumnLink("first_name")
    private String firstName;
    @ColumnLink("middle_name")
    private String middleName;
    @ColumnLink("blocked")
    private boolean status;

    public StudentsStatus() {

    }
    public StudentsStatus(String lastName, String firstName,
                          String middleName, boolean status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.status = status;
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

    public boolean getStatus() {
        return this.status;
    }
}
