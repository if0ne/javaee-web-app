package ru.rsreu.javaeewebapp;

import ru.rsreu.javaeewebapp.interfaces.*;

public abstract class DaoFactory {

    public static DaoFactory getInstance(DbType dbType) {
        DaoFactory result = dbType.getDAOFactory();
        return result;
    }

    public abstract CoursesDAO getCoursesDAO();
    public abstract ProgressDAO getProgressDAO();
    public abstract UsersDAO getUsersDAO();
    public abstract ModifiedCourseDAO getModifiedCourseDAO();
    public abstract ModifiedUserDAO getModifiedUserDAO();

}

