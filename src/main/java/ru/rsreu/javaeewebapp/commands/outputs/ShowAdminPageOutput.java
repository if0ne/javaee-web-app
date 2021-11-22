package ru.rsreu.javaeewebapp.commands.outputs;

import ru.rsreu.javaeewebapp.models.UserRole;

import java.util.List;

public class ShowAdminPageOutput {

    private List<UserRole> allUsers;

    public List<UserRole> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<UserRole> allUsers) {
        this.allUsers = allUsers;
    }
}
