package ru.rsreu.javaeewebapp.dao.oracle;

import ru.rsreu.javaeewebapp.Client;
import ru.rsreu.javaeewebapp.interfaces.UsersDAO;
import ru.rsreu.javaeewebapp.models.StudentStatus;
import ru.rsreu.javaeewebapp.models.User;
import ru.rsreu.javaeewebapp.models.UserName;
import ru.rsreu.javaeewebapp.models.UserRole;
import ru.rsreu.javaeewebapp.models.enums.Role;
import ru.rsreu.javaeewebapp.util.MessageManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OracleUsersDAO implements UsersDAO {

    private static final String SQL_GET_STUDENTS_STATUSES = MessageManager.getProperty("sql.user.status");
    private static final String SQL_GET_USERS_ROLES = MessageManager.getProperty("sql.user.role");
    private static final String SQL_GET_LOGGED_USER = MessageManager.getProperty("sql.user.logged");
    private static int FIRST_LIST_ELEMENT = 0;
    private static final String ADMINISTRATOR = "Администратор";
    private static final String STUDENT = "Студент";

    private Client client;

    public OracleUsersDAO(Client client) {
        this.client = client;
    }

    @Override
    public List<StudentStatus> getStudentsStatuses() {
        List<StudentStatus> result = new ArrayList<StudentStatus>();
        List<Map<String, Object>> rows = client.selectData(SQL_GET_STUDENTS_STATUSES, STUDENT);

        for(Map<String, Object> row : rows) {
            result.add(getStudentStatusFromMap(row));
        }
        return result;
    }

    private StudentStatus getStudentStatusFromMap(Map<String, Object> row) {
        return new StudentStatus((Integer) row.get("id_user"),
                new UserName((String) row.get("last_name"),
                        (String) row.get("first_name"),
                        (String) row.get("middle_name")),
                (boolean) row.get("blocked"));
    }

    @Override
    public List<UserRole> getAllUsersRoles() {
        List<UserRole> result = new ArrayList<UserRole>();
        List<Map<String, Object>> rows = client.selectData(SQL_GET_USERS_ROLES, ADMINISTRATOR);

        for(Map<String, Object> row : rows) {
            result.add(getUserRoleFromMap(row));
        }
        return result;
    }

    private UserRole getUserRoleFromMap(Map<String, Object> row) {
        return new UserRole((Integer) row.get("id_user"),
                new UserName((String) row.get("last_name"),
                        (String) row.get("first_name"),
                        (String) row.get("middle_name")),
                (Role) row.get("name"));
    }

    @Override
    public User getLoggedUser(String login, String password) {
        List<User> result = new ArrayList<User>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_GET_LOGGED_USER,
                                                                login, password);

        for (Map<String, Object> row : rows) {
            result.add(getUserFromMap(row));
        }
        return result.get(FIRST_LIST_ELEMENT);
    }

    private User getUserFromMap(Map<String, Object> row) {
        return new User((Integer) row.get("id_user"),
                (Role) row.get("role"),
                new UserName((String) row.get("last_name"),
                            (String) row.get("first_name"),
                            (String) row.get("middle_name")),
                (boolean) row.get("blocked"));
    }

}
