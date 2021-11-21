package ru.rsreu.javaeewebapp.dao.oracle;

import ru.rsreu.javaeewebapp.Client;
import ru.rsreu.javaeewebapp.interfaces.CoursesDAO;
import ru.rsreu.javaeewebapp.models.*;
import ru.rsreu.javaeewebapp.models.enums.Attendance;
import ru.rsreu.javaeewebapp.models.enums.FinalGrade;
import ru.rsreu.javaeewebapp.models.enums.Grade;
import ru.rsreu.javaeewebapp.util.MessageManager;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OracleCoursesDAO implements CoursesDAO {

    private static final String SQL_GET_TEACHER_COURSES = MessageManager.getProperty("sql.course.teacher");
    private static final String SQL_NEXT_DATE = MessageManager.getProperty("sql.next.date");
    private static final String SQL_GET_STUDENT_COURSES = MessageManager.getProperty("sql.course.student");
    private static final String SQL_GET_UNUSED_STUDENT_COURSES = MessageManager.getProperty("sql.course.unused");
    private static final String SQL_GET_COURSE_INFORMATION = MessageManager.getProperty("sql.course.info");
    private static final String SQL_GET_DATES = MessageManager.getProperty("sql.course.dates");
    private static final String SQL_GET_STUDENTS = MessageManager.getProperty("sql.all.students.of.course");
    private static final String SQL_GET_PROGRESS = MessageManager.getProperty("sql.progress");
    private static final int FIRST_LIST_ELEMENT = 0;

    private Client client;

    public OracleCoursesDAO(Client client) {
        this.client = client;
    }

    @Override
    public List<TeacherCourse> getAllTeacherCourses(int teacherId) {
        List<TeacherCourse> result = new ArrayList<TeacherCourse>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_GET_TEACHER_COURSES,
                                                            Integer.toString(teacherId));

        for (Map<String, Object> row : rows) {
            result.add(getTeacherCoursesFromMap(row));
        }
        return result;
    }

    private TeacherCourse getTeacherCoursesFromMap(Map<String, Object> row) {
        return new TeacherCourse(
                (Integer) row.get("id_course"),
                (String) row.get("name"),
                (Integer) row.get("count"),
                getNextDate((Integer) row.get("id_course"))
        );
    }

    private Date getNextDate(int id_course) {
        List<Date> result = new ArrayList<Date>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_NEXT_DATE,
                                                    Integer.toString(id_course));

        for (Map<String, Object> row : rows) {
            result.add(getNextDateFromMap(row));
        }
        return result.get(FIRST_LIST_ELEMENT);
    }

    private Date getNextDateFromMap(Map<String, Object> row) {
        return (Date) row.get("next_date");
    }

    @Override
    public List<Course> getStudentCourses(int studentId) {
        List<Course> result = new ArrayList<Course>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_GET_STUDENT_COURSES,
                                                            Integer.toString(studentId));

        for (Map<String, Object> row : rows) {
            result.add(getCourseFromMap(row));
        }
        return result;
    }

    @Override
    public List<Course> getAllStudentCourses(int studentId) {
        List<Course> result = new ArrayList<Course>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_GET_STUDENT_COURSES,
                Integer.toString(studentId));

        for (Map<String, Object> row : rows) {
            result.add(getCourseFromMap(row));
        }
        rows = this.client.selectData(SQL_GET_UNUSED_STUDENT_COURSES,
                                    Integer.toString(studentId));
        for (Map<String, Object> row : rows) {
            result.add(getCourseFromMap(row));
        }
        return result;
    }

    private Course getCourseFromMap(Map<String, Object> row) {
        return new Course((Integer) row.get("id_course"),
                            (String) row.get("name"),
                            (String) row.get("description"),
                            new UserName((String) row.get("last_name"),
                                        (String) row.get("first_name"),
                                        (String) row.get("middle_name")));
    }

    @Override
    public SpecificCourse getCourseInformation(int courseId) {
        List<SpecificCourse> result = new ArrayList<SpecificCourse>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_GET_COURSE_INFORMATION,
                                                                Integer.toString(courseId));

        for (Map<String, Object> row : rows) {
            result.add(getCourseInformationFromMap(row, courseId));
        }
        return result.get(FIRST_LIST_ELEMENT);
    }

    private SpecificCourse getCourseInformationFromMap(Map<String, Object> row,
                                                       int courseId) {
        List<Dates> dates = getCourseDates(courseId);
        List<Student> students = getCourseStudents(courseId);
        return new SpecificCourse((Integer) row.get("id_course"),
                                    (String) row.get("name"),
                                    new UserName((String) row.get("last_name"),
                                                (String) row.get("first_name"),
                                                (String) row.get("middle_name")),
                                    (String) row.get("description"),
                                    dates, students);

    }

    private List<Dates> getCourseDates(int courseId) {
        List<Dates> result = new ArrayList<Dates>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_GET_DATES);

        for (Map<String, Object> row : rows) {
            result.add(getDatesFromMap(row));
        }
        return result;
    }

    private Dates getDatesFromMap(Map<String, Object> row) {
        return new Dates((Integer) row.get("id_date"),
                    (Date) row.get("course_date"));
    }

    private List<Student> getCourseStudents(int courseId) {
        List<Student> result = new ArrayList<Student>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_GET_STUDENTS);

        for (Map<String, Object> row : rows) {
            result.add(getStudentsFromMap(row));
        }
        return result;
    }

    private Student getStudentsFromMap(Map<String, Object> row) {
        return new Student((Integer) row.get("id_user"),
                new UserName((String) row.get("last_name"),
                        (String) row.get("first_name"),
                        (String) row.get("middle_name")),
                (FinalGrade) row.get("final_grade"),
                getProgressList((Integer) row.get("id_user")));
    }

    private List<Progress> getProgressList(int id_user) {
        List<Progress> result = new ArrayList<Progress>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_GET_PROGRESS);

        for (Map<String, Object> row : rows) {
            result.add(getProgressFromMap(row));
        }
        return result;
    }

    private Progress getProgressFromMap(Map<String, Object> row) {
        return new Progress((Attendance) row.get("attendance"),
                            (Grade) row.get("grade"));
    }

}
