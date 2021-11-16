package ru.rsreu.javaeewebapp.dao.oracle;

import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.javaeewebapp.Client;
import ru.rsreu.javaeewebapp.interfaces.UsersDAO;
import ru.rsreu.javaeewebapp.models.StudentStatus;
import ru.rsreu.javaeewebapp.models.User;
import ru.rsreu.javaeewebapp.models.UserRole;
import ru.rsreu.javaeewebapp.util.MapClassConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OracleUsersDAO implements UsersDAO {

    private static final String SQL_GET_STUDENTS_STATUSES = Resourcer.getString("sql.query.user.statuses");
    private static final String SQL_GET_USERS_ROLES = Resourcer.getString("sql.query.user.roles");

    private Client client;

    public OracleUsersDAO(Client client) {
        this.client = client;
    }

    @Override
    public List<StudentStatus> getStudentsStatuses() {
        List<StudentStatus> result = new ArrayList<StudentStatus>();
        List<Map<String, Object>> rows = client.selectData(SQL_GET_STUDENTS_STATUSES);

        for(Map<String, Object> row : rows) {
            result.add(MapClassConverter.getObjectFromMap(row, StudentStatus.class));
        }
        return result;
    }

    @Override
    public List<UserRole> getAllUsersRoles() {
        List<UserRole> result = new ArrayList<UserRole>();
        List<Map<String, Object>> rows = client.selectData(SQL_GET_USERS_ROLES);

        for(Map<String, Object> row : rows) {
            result.add(MapClassConverter.getObjectFromMap(row, UserRole.class));
        }
        return result;
    }

    @Override
    public User getLoggedUser(String login, String password) {
        return null;
    }
}
