package ru.rsreu.javaeewebapp.models;

public class StudentsStatus {
    private String lastName;
    private String firstName;
    private String middleName;
    private boolean status;

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
