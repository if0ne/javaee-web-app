package ru.rsreu.javaeewebapp.util;

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
        return DriverManager.getConnection(url, user, pass);
    }
}