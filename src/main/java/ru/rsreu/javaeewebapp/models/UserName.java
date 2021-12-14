package ru.rsreu.javaeewebapp.models;

import ru.rsreu.javaeewebapp.util.MessageManager;

import java.io.Serializable;

/**
 * data class for storing the last name, first name and patronymic
 */
public class UserName implements Serializable {

    private String lastName;
    private String firstName;
    private String middleName;

    public UserName(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = (middleName != null) ? middleName : "";
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFullName() {
        return String.format(MessageManager.getProperty("format.fullname"),
                            this.lastName, this.firstName, this.middleName);
    }

    public String getLastAndFirstName() {
        return String.format(MessageManager.getProperty("format.lastandfirstname"),
                            this.lastName, this.firstName);
    }
}
