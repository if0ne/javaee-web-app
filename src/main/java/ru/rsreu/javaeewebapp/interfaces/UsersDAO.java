package ru.rsreu.javaeewebapp.interfaces;

import ru.rsreu.javaeewebapp.models.StudentStatus;
import ru.rsreu.javaeewebapp.models.User;
import ru.rsreu.javaeewebapp.models.UserRole;

import java.util.List;

public interface UsersDAO {
    //список студентов и их статусы
    List<StudentStatus> getStudentsStatuses();
    //all users list without administrator and their roles
    List<UserRole> getAllUsersRoles();

    //user who logged in system
    User getLoggedUser(String login, String password);
}