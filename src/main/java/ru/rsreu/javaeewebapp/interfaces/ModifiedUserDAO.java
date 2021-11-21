package ru.rsreu.javaeewebapp.interfaces;

import ru.rsreu.javaeewebapp.Client;
import ru.rsreu.javaeewebapp.dao.oracle.OracleModifiedUserDAO;

public interface ModifiedUserDAO {

    //change database
    //create user 2
    void createUser(String lastName, String firstName, String middleName, String login, String password, int role);
    //delete user 4
    void deleteUser(int userId);
    //change user status 14
    void updateUserStatus(int studentId, int newStatus);
}
