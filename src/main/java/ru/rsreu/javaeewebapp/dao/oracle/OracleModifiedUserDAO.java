package ru.rsreu.javaeewebapp.dao.oracle;

import ru.rsreu.javaeewebapp.Client;
import ru.rsreu.javaeewebapp.interfaces.ModifiedUserDAO;
import ru.rsreu.javaeewebapp.util.MessageManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OracleModifiedUserDAO implements ModifiedUserDAO {

    private static final String SQL_UPDATE_USER_STATUS = MessageManager.getProperty("sql.user.update.status");
    private static final String SQL_DELETE_USER = MessageManager.getProperty("sql.user.delete");
    private static final String SQL_CREATE_USER = MessageManager.getProperty("sql.user.create");
    private static final String SQL_NEW_ID_USER = MessageManager.getProperty("sql.new.id.user");
    private static final String SQL_UPDATE_LOGGED_STATUS = MessageManager.getProperty("sql.update.logged.status");
    private static final int FIRST_LIST_ELEMENT = 0;

    private Client client;

    public OracleModifiedUserDAO(Client client) {
        this.client = client;
    }

    @Override
    public void createUser(String lastName, String firstName, String middleName,
                           String login, String password, int role) {
        String userId = getNewId(SQL_NEW_ID_USER);
        this.client.updateData(SQL_CREATE_USER, userId, login, password, lastName, firstName, middleName,
                Integer.toString(role));
    }
    private String getNewId(String sql) {
        return Integer.toString(getCurrentId(sql) + 1);
    }

    private Integer getCurrentId(String sql) {
        List<Integer> id = new ArrayList<Integer>();
        List<Map<String, Object>> rows = this.client.selectData(sql);

        for (Map<String, Object> row : rows) {
            id.add(getIdFromMap(row));
        }
        if (id.size() == 0) {
            return FIRST_LIST_ELEMENT;
        } else {
            return id.get(FIRST_LIST_ELEMENT);
        }
    }

    private Integer getIdFromMap(Map<String, Object> row) {
        return ((BigDecimal) row.get("id")).intValueExact();
    }

    @Override
    public void deleteUser(int userId) {
        this.client.updateData(SQL_DELETE_USER, Integer.toString(userId));
    }

    @Override
    public void updateUserStatus(int studentId, int newStatus) {
        this.client.updateData(SQL_UPDATE_USER_STATUS, Integer.toString(newStatus),
                                Integer.toString(studentId));
    }

    @Override
    public void updateLoggedUserStatus(int userId, boolean loggedStatus) {
        this.client.updateData(SQL_UPDATE_LOGGED_STATUS, Integer.toString(loggedStatus ? 1 : 0),
                                Integer.toString(userId));
    }


}
