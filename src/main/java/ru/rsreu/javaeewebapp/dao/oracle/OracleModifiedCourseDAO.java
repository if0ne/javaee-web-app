package ru.rsreu.javaeewebapp.dao.oracle;

import ru.rsreu.javaeewebapp.Client;
import ru.rsreu.javaeewebapp.DaoFactory;
import ru.rsreu.javaeewebapp.interfaces.ModifiedCourseDAO;
import ru.rsreu.javaeewebapp.models.Dates;
import ru.rsreu.javaeewebapp.util.DateStringConverter;
import ru.rsreu.javaeewebapp.util.MessageManager;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
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
    private static final String SQL_NEW_ID_CLASS = MessageManager.getProperty("sql.new.id.class");
    private static final String SQL_ADD_RATING = MessageManager.getProperty("sql.signup.rating");
    private static final String SQL_ADD_CLASSES = MessageManager.getProperty("sql.signup.classes");
    private static final String SQL_COURSE_DATES = MessageManager.getProperty("sql.course.dates");
    private static final String EMPTY = "";
    private static final int FIRST_LIST_ELEMENT = 0;

    private Client client;

    public OracleModifiedCourseDAO(Client client) {
        this.client = client;
    }

    @Override
    public void createCourse(int teacherId, String title, String description, List<Date> dates) {
        try {
            String courseId = getNewId(SQL_NEW_ID_COURSE);
            courseId = courseId == "" ? "0" : courseId;
            this.client.updateData(SQL_CREATE_COURSE, courseId, title,
                    description, Integer.toString(teacherId));
            Integer dateId = Integer.parseInt(getNewId(SQL_NEW_ID_DATA));
            for (Date date : dates) {
                this.client.updateData(SQL_ADD_COURSE_DATES, dateId.toString(),
                        DateStringConverter.convertDateToString(date), courseId);
                dateId++;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void signUpToCourse(int studentId, int courseId) {
        String id = getNewId(SQL_NEW_ID_USER_COURSE);
        String ratingId = getNewId(SQL_NEW_ID_RATING);
        this.client.updateData(SQL_SIGN_UP_COURSE, id, Integer.toString(studentId),
                                Integer.toString(courseId), ratingId);
        this.client.updateData(SQL_ADD_RATING, ratingId, EMPTY);
        List<Dates> dates = getDates(courseId);
        for (Dates date : dates) {
            String classId = getNewId(SQL_NEW_ID_CLASS);
            this.client.updateData(SQL_ADD_CLASSES, classId, ratingId, date.getStringDate(), null, null);
        }
    }

    private List<Dates> getDates(int courseId) {
        List<Dates> result = new ArrayList<Dates>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_COURSE_DATES,
                                                        Integer.toString(courseId));

        for (Map<String, Object> row : rows) {
            result.add(getDateFromMap(row));
        }
        return result;
    }

    private Dates getDateFromMap(Map<String, Object> row) {
        return new Dates(((BigDecimal) row.get("id_date")).intValueExact(),
                new Date(((Timestamp) row.get("course_date")).getTime()));
    }

    @Override
    public void dropOutStudent(int studentId, int courseId) {
        this.client.updateData(SQL_DROP_OUT, Integer.toString(studentId),
                                            Integer.toString(courseId));
    }

    private String getNewId(String sql) {
        List<Integer> id = new ArrayList<Integer>();
        List<Map<String, Object>> rows = this.client.selectData(sql);

        for (Map<String, Object> row : rows) {
            id.add(getIdFromMap(row));
        }
        if (id.size() == 0) {
            return Integer.toString(FIRST_LIST_ELEMENT);
        } else {

            return Integer.toString(id.get(FIRST_LIST_ELEMENT) + 1);
        }
    }

    private Integer getIdFromMap(Map<String, Object> row) {
        return ((BigDecimal) row.get("id")).intValueExact();
    }

}
