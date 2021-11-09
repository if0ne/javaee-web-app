package ru.rsreu.javaeewebapp.models.enums;

public enum Role {
    ADMINISTRATOR(0), MODERATOR(1), TEACHER(2), STUDENT(3), GUEST(4);

    private int role;

    Role(int role) {
       this.role = role;
    }

    public int getRoleId() {
       return this.role;
    }
}
