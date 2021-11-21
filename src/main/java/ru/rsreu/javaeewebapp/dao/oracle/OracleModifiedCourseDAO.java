package ru.rsreu.javaeewebapp.dao.oracle;

import ru.rsreu.javaeewebapp.Client;
import ru.rsreu.javaeewebapp.interfaces.ModifiedCourseDAO;
import ru.rsreu.javaeewebapp.util.DateStringConverter;
import ru.rsreu.javaeewebapp.util.MessageManager;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OracleModifiedCourseDAO implements ModifiedCourseDAO {

    private static final String SQL_CREATE_COURSE = MessageManager.getProperty("sql.create.course");
    private static final String SQL_ADD_COURSE_DATES = MessageManager.getProperty("sql.add.course.dates");
    private static final String SQL_SIGN_UP_COURSE = MessageManager.getProperty("sql.signup.course");
    private static final String SQL_DROP_OUT = MessageManager.getProperty("sql.drop.out");
    private static final String SQL_NEW_ID_COURSE = MessageManager.getProperty("sql.new.id.course");
    private static final String SQL_NEW_ID_DATA = MessageManager.getProperty("sql.new.id.data");
    private static final String SQL_NEW_ID_RATING = MessageManager.getProperty("sql.new.id.rating");
    private static final String SQL_NEW_ID_USER_COURSE = MessageManager.getProperty("sql.new.id.user.course");
    private static final int FIRST_LIST_ELEMENT = 0;

    private Client client;

    public OracleModifiedCourseDAO(Client client) {
        this.client = client;
    }

    @Override
    public void createCourse(int teacherId, String title, String description, List<Date> dates) {
        String courseId = getNewId(SQL_NEW_ID_COURSE);
        this.client.updateData(SQL_CREATE_COURSE, courseId, title,
                                description, Integer.toString(teacherId));
        String dateId = getNewId(SQL_NEW_ID_DATA);
        for (Date date : dates) {
            this.client.updateData(SQL_ADD_COURSE_DATES, dateId,
                    DateStringConverter.convertDateToString(date), courseId);
        }
    }

    @Override
    public void signUpToCourse(int studentId, int courseId) {
        String id = getNewId(SQL_NEW_ID_USER_COURSE);
        String ratingId = getNewId(SQL_NEW_ID_RATING);
        this.client.updateData(SQL_SIGN_UP_COURSE, id, Integer.toString(studentId),
                                Integer.toString(courseId), ratingId);
    }

    @Override
    public void dropOutStudent(int studentId, int courseId) {
        this.client.updateData(SQL_DROP_OUT, Integer.toString(studentId),
                                            Integer.toString(courseId));
    }

    private String getNewId(String sql) {
        return Integer.toString(Integer.parseInt(getCurrentId(sql)) + 1);
    }

    private String getCurrentId(String sql) {
        List<String> id = new ArrayList<String>();
        List<Map<String, Object>> rows = this.client.selectData(sql);

        for (Map<String, Object> row : rows) {
            id.add(getIdFromMap(row));
        }
        return id.get(FIRST_LIST_ELEMENT);
    }

    private String getIdFromMap(Map<String, Object> row) {
        return (String) row.get("id");
    }

}
