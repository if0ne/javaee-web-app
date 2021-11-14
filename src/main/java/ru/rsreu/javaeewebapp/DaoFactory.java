package ru.rsreu.javaeewebapp;

import ru.rsreu.javaeewebapp.interfaces.CoursesDAO;
import ru.rsreu.javaeewebapp.interfaces.ProgressDAO;
import ru.rsreu.javaeewebapp.interfaces.UsersDAO;

public abstract class DaoFactory {

    public static DaoFactory getInstance(DbType dbType) {
        DaoFactory result = dbType.getDAOFactory();
        return result;
    }

    public abstract CoursesDAO getCoursesDAO();
    public abstract ProgressDAO getProgressDAO();
    public abstract UsersDAO getUsersDAO();

}

