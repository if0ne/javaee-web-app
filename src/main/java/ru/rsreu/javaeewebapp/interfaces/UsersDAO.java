package ru.rsreu.javaeewebapp.interfaces;

import ru.rsreu.javaeewebapp.models.StudentsStatus;
import ru.rsreu.javaeewebapp.models.UsersRoles;

import java.util.List;

public interface UsersDAO {
    //список студентов и их статусы
    List<StudentsStatus> getStudentsStatuses();
    //список всех пользователей и их роли
    List<UsersRoles> getAllUsersRoles();
}
