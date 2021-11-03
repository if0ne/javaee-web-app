package ru.rsreu.javaeewebapp;

public abstract class DaoFactory {

    public static DaoFactory getInstance(DbType dbType) {
        DaoFactory result = dbType.getDAOFactory();
        return result;
    }

}

