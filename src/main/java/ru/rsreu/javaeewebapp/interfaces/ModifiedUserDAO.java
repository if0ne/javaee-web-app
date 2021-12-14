package ru.rsreu.javaeewebapp.interfaces;

import ru.rsreu.javaeewebapp.Client;
import ru.rsreu.javaeewebapp.dao.oracle.OracleModifiedUserDAO;

public interface ModifiedUserDAO {

    /**
     * write a new record to the users table
     * @param lastName
     * @param firstName
     * @param middleName
     * @param login
     * @param password
     * @param role
     */
    void createUser(String lastName, String firstName, String middleName, String login, String password, int role);

    /**
     * delete user with userId id from the users table
     * @param userId - user id
     */
    void deleteUser(int userId);

    /**
     * changes the user status when blocking / unblocking it by a moderator
     * @param studentId - user id (you can only block / unblock users with the student role)
     * @param newStatus - blocked / unblocked status
     */
    void updateUserStatus(int studentId, int newStatus);
}
