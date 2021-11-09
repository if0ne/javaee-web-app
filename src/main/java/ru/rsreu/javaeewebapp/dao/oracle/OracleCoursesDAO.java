package ru.rsreu.javaeewebapp.dao.oracle;

import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.javaeewebapp.Client;
import ru.rsreu.javaeewebapp.interfaces.CoursesDAO;
import ru.rsreu.javaeewebapp.models.Course;
import ru.rsreu.javaeewebapp.models.TeacherCourse;
import ru.rsreu.javaeewebapp.util.MapClassConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OracleCoursesDAO implements CoursesDAO {

    private static final String SQL_GET_TEACHER_COURSES = Resourcer.getString("sql.query.course.teacher");
    private static final String SQL_GET_STUDENT_COURSES = Resourcer.getString("sql.query.course.student");
    private static final String SQL_GET_UNUSED_STUDENT_COURSES = Resourcer.getString("sql.query.course.unused");
    private static final String SQL_GET_COURSE_INFORMATION = Resourcer.getString("sql.query.course.info");
    private static final int ONE_COURSE = 0;

    private Client client;

    public OracleCoursesDAO(Client client) {
        this.client = client;
    }

    @Override
    public List<TeacherCourse> getAllTeacherCourses(int teacher) {
        List<TeacherCourse> result = new ArrayList<TeacherCourse>();
        List<Map<String, Object>> rows = client.selectData(SQL_GET_TEACHER_COURSES, teacher);

        for (Map<String, Object> row : rows) {
            result.add(MapClassConverter.getObjectFromMap(row, TeacherCourse.class));
        }
        return result;
    }

    @Override
    public List<Course> getStudentCourses(int student) {
        return getCourses(SQL_GET_STUDENT_COURSES, student);
    }

    @Override
    public List<Course> getUnusedStudentCourses(int student) {
        return getCourses(SQL_GET_UNUSED_STUDENT_COURSES, student);
    }

    @Override
    public Course getCourseInformation(int course) {
        return getCourses(SQL_GET_COURSE_INFORMATION, course).get(ONE_COURSE);
    }

    private List<Course> getCourses(String query, int id) {
        List<Course> result = new ArrayList<Course>();
        List<Map<String, Object>> rows = client.selectData(query, id);

        for (Map<String, Object> row : rows) {
            result.add(MapClassConverter.getObjectFromMap(row, Course.class));
        }
        return result;
    }
}
