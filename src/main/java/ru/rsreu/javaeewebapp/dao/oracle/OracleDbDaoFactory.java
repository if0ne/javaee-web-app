package ru.rsreu.javaeewebapp.dao.oracle;

import ru.rsreu.javaeewebapp.Client;
import ru.rsreu.javaeewebapp.DaoFactory;

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
}
