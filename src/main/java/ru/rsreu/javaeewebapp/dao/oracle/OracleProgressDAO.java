package ru.rsreu.javaeewebapp.dao.oracle;

import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.javaeewebapp.Client;
import ru.rsreu.javaeewebapp.interfaces.ProgressDAO;
import ru.rsreu.javaeewebapp.models.Progress;
import ru.rsreu.javaeewebapp.util.MapClassConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OracleProgressDAO implements ProgressDAO {

    private static final String SQL_GET_STUDENT_PROGRESS = Resourcer.getString("sql.query.progress");

    private Client client;

    public OracleProgressDAO(Client client) {
        this.client = client;
    }

    @Override
    public List<Progress> getStudentsProgress(int course) {
        List<Progress> result = new ArrayList<Progress>();
        List<Map<String, Object>> rows = client.selectData(SQL_GET_STUDENT_PROGRESS, course);

        for (Map<String, Object> row : rows) {
            result.add(MapClassConverter.getObjectFromMap(row, Progress.class));
        }
        return result;
    }
}
