package ru.rsreu.javaeewebapp.dao.oracle;

import ru.rsreu.javaeewebapp.Client;
import ru.rsreu.javaeewebapp.DaoFactory;
import ru.rsreu.javaeewebapp.interfaces.*;

import java.sql.SQLException;

public class OracleDbDaoFactory extends DaoFactory {

    private static volatile OracleDbDaoFactory instance;

    private Client client;

    public static OracleDbDaoFactory getInstance() throws SQLException {
        OracleDbDaoFactory factory = instance;
        if (instance == null) {
            synchronized (OracleDbDaoFactory.class) {
                instance = factory = new OracleDbDaoFactory();
                factory.connect();
            }
        }
        return factory;
    }

    private void connect() throws SQLException {
        client = new Client();
    }

    protected void finalize() throws Throwable {
        client.close();
    }

    @Override
    public CoursesDAO getCoursesDAO() {
        return new OracleCoursesDAO(client);
    }

    @Override
    public ProgressDAO getProgressDAO() {
        return new OracleProgressDAO(client);
    }

    @Override
    public UsersDAO getUsersDAO() {
        return new OracleUsersDAO(client);
    }

    @Override
    public ModifiedCourseDAO getModifiedCourseDAO() {
        return new OracleModifiedCourseDAO(client);
    }

    @Override
    public ModifiedUserDAO getModifiedUserDAO() {
        return new OracleModifiedUserDAO(client);
    }

}
