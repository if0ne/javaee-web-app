package ru.rsreu.javaeewebapp.dao.oracle;

import ru.rsreu.javaeewebapp.Client;
import ru.rsreu.javaeewebapp.interfaces.UsersDAO;
import ru.rsreu.javaeewebapp.models.StudentStatus;
import ru.rsreu.javaeewebapp.models.User;
import ru.rsreu.javaeewebapp.models.UserName;
import ru.rsreu.javaeewebapp.models.UserRole;
import ru.rsreu.javaeewebapp.models.enums.Role;
import ru.rsreu.javaeewebapp.util.MessageManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OracleUsersDAO implements UsersDAO {

    private static final String SQL_GET_STUDENTS_STATUSES = MessageManager.getProperty("sql.user.status");
    private static final String SQL_GET_USERS_ROLES = MessageManager.getProperty("sql.user.role");
    private static final String SQL_GET_LOGGED_USER = MessageManager.getProperty("sql.user.logged");
    private static int FIRST_LIST_ELEMENT = 0;

    private Client client;

    public OracleUsersDAO(Client client) {
        this.client = client;
    }

    @Override
    public List<StudentStatus> getStudentsStatuses() {
        List<StudentStatus> result = new ArrayList<StudentStatus>();
        List<Map<String, Object>> rows = client.selectData(SQL_GET_STUDENTS_STATUSES);

        for(Map<String, Object> row : rows) {
            result.add(getStudentStatusFromMap(row));
        }
        return result;
    }

    private StudentStatus getStudentStatusFromMap(Map<String, Object> row) {
        return new StudentStatus(((BigDecimal) row.get("id_user")).intValueExact(),
                                    row.get("login").toString(),
                                    new UserName(row.get("last_name").toString(),
                                                row.get("first_name").toString(),
                                                row.get("middle_name").toString()),
                                    (boolean) row.get("blocked"));
    }

    @Override
    public List<UserRole> getAllUsersRoles() {
        List<UserRole> result = new ArrayList<UserRole>();
        List<Map<String, Object>> rows = client.selectData(SQL_GET_USERS_ROLES);

        for(Map<String, Object> row : rows) {
            result.add(getUserRoleFromMap(row));
        }
        return result;
    }

    private UserRole getUserRoleFromMap(Map<String, Object> row) {
        return new UserRole(((BigDecimal) row.get("id_user")).intValueExact(),
                row.get("login").toString(),
                new UserName(
                        row.get("last_name").toString(),
                        row.get("first_name").toString(),
                        row.get("middle_name").toString()),
                Role.getRoleFromInt(((BigDecimal) row.get("id_role")).intValueExact()));
    }

    @Override
    public User getLoggedUser(String login, String password) {
        List<User> result = new ArrayList<User>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_GET_LOGGED_USER,
                                                                login, password);

        for (Map<String, Object> row : rows) {
            result.add(getUserFromMap(row));
        }
        if (result.size() == 0) {
            return null;
        } else {
            return result.get(FIRST_LIST_ELEMENT);
        }
    }

    private User getUserFromMap(Map<String, Object> row) {
        return new User(((BigDecimal) row.get("id_user")).intValueExact(),
                row.get("login").toString(),
                Role.getRoleFromInt(((BigDecimal) row.get("id_role")).intValueExact()) ,
                new UserName(row.get("last_name").toString(),
                            row.get("first_name").toString(),
                            row.get("middle_name") != null ? row.get("middle_name").toString() : ""),
                ((BigDecimal) row.get("blocked")).intValueExact() == 0);
    }
}
