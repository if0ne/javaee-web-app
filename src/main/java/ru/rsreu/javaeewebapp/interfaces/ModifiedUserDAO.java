package ru.rsreu.javaeewebapp.interfaces;

import ru.rsreu.javaeewebapp.Client;
import ru.rsreu.javaeewebapp.dao.oracle.OracleModifiedUserDAO;

public interface ModifiedUserDAO {

    //change database
    //create user
    void createUser(String lastName, String firstName, String middleName, String login, String password, int role);
    //delete user
    void deleteUser(int userId);
    //change user status
    void updateUserStatus(int studentId, int newStatus);
}
