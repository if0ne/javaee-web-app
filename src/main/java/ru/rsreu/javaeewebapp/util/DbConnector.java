package ru.rsreu.javaeewebapp.util;

import oracle.jdbc.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
            Properties properties = new Properties();
            properties.put("user", user);
            properties.put("password", pass);
            properties.put("charSet", "chcp1251");
            connection = DriverManager.getConnection(url, properties);
        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
        return connection;
    }
}