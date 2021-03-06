package ru.rsreu.javaeewebapp;

import ru.rsreu.javaeewebapp.util.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Client {

    private Connection connect;

    public Client() throws SQLException {
        connect = DbConnector.getConnection();
    }

    public List<Map<String, Object>> selectData(String sql, String...params) {
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();

        try (PreparedStatement statement = connect.prepareStatement(sql)) {
            for (int index = 0; index < params.length; ++index) {
                statement.setString(index + 1, params[index]);
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<String, Object>();
                for (int column = 1; column <= resultSet.getMetaData().getColumnCount(); ++column) {
                    row.put(resultSet.getMetaData().getColumnName(column).toLowerCase(), resultSet.getObject(column));
                }
                rows.add(row);
            }

        } catch (SQLException ignored) {

        }

        return rows;
    }

    public void updateData(String sql, String...params) {
        try (PreparedStatement statement = connect.prepareStatement(sql)) {
            for (int index = 0; index < params.length; ++index) {
                statement.setString(index + 1, params[index]);
            }
            int rowCount = statement.executeUpdate();
            System.out.println("Обработано строк: " + rowCount);
        } catch (SQLException ignored) {
            System.err.println("==============================================================");
            System.err.println(ignored.getMessage());
            System.err.println("==============================================================");
        }
    }

    public void close() {
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException e) {

        }
    }
}