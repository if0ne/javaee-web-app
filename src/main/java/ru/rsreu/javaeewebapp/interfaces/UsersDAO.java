package ru.rsreu.javaeewebapp.interfaces;

import ru.rsreu.javaeewebapp.models.StudentStatus;
import ru.rsreu.javaeewebapp.models.User;
import ru.rsreu.javaeewebapp.models.UserRole;

import java.util.List;

public interface UsersDAO {


    /**
     *
     * @return list of all existed students with their statuses (blocked / unblocked) for moderator
     */
    List<StudentStatus> getStudentsStatuses();
    //all users list without administrator and their roles

    /**
     *
     * @return list of all existed users with their roles (without administrator) for administrator
     */
    List<UserRole> getAllUsersRoles();

    /**
     *
     * @param login
     * @param password
     * @return
     */
    User getLoggedUser(String login, String password);
    // check existed login
    boolean isExistedUser(String login);
}
