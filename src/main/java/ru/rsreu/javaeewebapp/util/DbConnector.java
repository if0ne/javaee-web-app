package ru.rsreu.javaeewebapp.util;

import oracle.jdbc.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConnector {
    private DbConnector() {

    }

    public static Connection getConnection() throws SQLException {
        String url = ConfigurationManager.getProperty("db.url");
        String user = ConfigurationManager.getProperty("db.user");
        String pass = ConfigurationManager.getProperty("db.password");
        Connection connection = null;
        try {
            DriverManager.registerDriver(new OracleDriver());
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
        return connection;
    }
}