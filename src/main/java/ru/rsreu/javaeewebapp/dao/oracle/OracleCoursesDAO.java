package ru.rsreu.javaeewebapp.dao.oracle;

import ru.rsreu.javaeewebapp.Client;
import ru.rsreu.javaeewebapp.interfaces.CoursesDAO;
import ru.rsreu.javaeewebapp.models.*;
import ru.rsreu.javaeewebapp.models.enums.Attendance;
import ru.rsreu.javaeewebapp.models.enums.FinalGrade;
import ru.rsreu.javaeewebapp.models.enums.Grade;
import ru.rsreu.javaeewebapp.util.MessageManager;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OracleCoursesDAO implements CoursesDAO {

    private static final String SQL_GET_TEACHER_COURSES = MessageManager.getProperty("sql.course.teacher");
    private static final String SQL_GET_STUDENTS_AMOUNT = MessageManager.getProperty("sql.course.students.number");
    private static final String SQL_NEXT_DATE = MessageManager.getProperty("sql.next.date");
    private static final String SQL_GET_STUDENT_COURSES = MessageManager.getProperty("sql.course.student");
    private static final String SQL_GET_UNUSED_STUDENT_COURSES = MessageManager.getProperty("sql.course.unused");
    private static final String SQL_GET_COURSE_INFORMATION = MessageManager.getProperty("sql.course.info");
    private static final String SQL_GET_DATES = MessageManager.getProperty("sql.course.dates");
    private static final String SQL_GET_STUDENTS = MessageManager.getProperty("sql.all.students.of.course");
    private static final String SQL_GET_PROGRESS = MessageManager.getProperty("sql.progress");
    private static final int FIRST_LIST_ELEMENT = 0;
    private static final boolean REGISTERED = true;
    private static final boolean UNREGISTERED = false;
    private static final boolean FINISHED_COURSE = false;
    private static final boolean ACTIVE_COURSE = true;

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
        Integer courseId = ((BigDecimal) row.get("id_course")).intValueExact();
        return new TeacherCourse(courseId, row.get("name").toString(),
                getStudentsNumber(courseId),
                getNextDate(courseId)
        );
    }

    private int getStudentsNumber(int courseId) {
        List<Integer> result = new ArrayList<Integer>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_GET_STUDENTS_AMOUNT,
                                                            Integer.toString(courseId));
        for (Map<String, Object> row : rows) {
            result.add(getCourseStudentsAmount(row));
        }
        if (result.size() == 0) {
            return FIRST_LIST_ELEMENT;
        } else {
            return result.get(FIRST_LIST_ELEMENT);
        }
    }

    private Integer getCourseStudentsAmount(Map<String, Object> row) {
        return ((BigDecimal) row.get("students_amount")).intValueExact();
    }

    private Date getNextDate(int courseId) {
        List<Date> dates = getAllCourseDate(courseId);
        java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
        for (Date date : dates) {
            if (date.after(currentDate) || date.equals(currentDate)) {
                return date;
            }
        }
        return null;
    }

    private List<Date> getAllCourseDate(int courseId) {
        List<Date> result = new ArrayList<>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_NEXT_DATE,
                                                Integer.toString(courseId));
        for (Map<String, Object> row : rows) {
            result.add(getNextDateFromMap(row));
        }
        return result;
    }

    private Date getNextDateFromMap(Map<String, Object> row) {
        return new Date(((Timestamp) row.get("course_date")).getTime());
    }

    @Override
    public List<Course> getStudentCourses(int studentId) {
        List<Course> result = new ArrayList<Course>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_GET_STUDENT_COURSES,
                                                            Integer.toString(studentId));

        for (Map<String, Object> row : rows) {
            result.add(getCourseFromMap(row, REGISTERED));
        }
        return result;
    }

    @Override
    public List<Course> getAllStudentCourses(int studentId) {
        List<Course> result = new ArrayList<Course>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_GET_STUDENT_COURSES,
                Integer.toString(studentId));

        for (Map<String, Object> row : rows) {
            result.add(getCourseFromMap(row, REGISTERED));
        }
        rows = this.client.selectData(SQL_GET_UNUSED_STUDENT_COURSES,
                                    Integer.toString(studentId));
        for (Map<String, Object> row : rows) {
            result.add(getCourseFromMap(row, UNREGISTERED));
        }
        return result;
    }

    private Course getCourseFromMap(Map<String, Object> row, boolean registrationStatus) {
        int courseId = ((BigDecimal) row.get("id_course")).intValueExact();
        return new Course(courseId,
                            row.get("name").toString(),
                            row.get("description").toString(),
                            new UserName(row.get("last_name").toString(),
                                        row.get("first_name").toString(),
                                        row.get("middle_name") != null ? row.get("middle_name").toString() : "s"),
                            registrationStatus, isActiveCourse(courseId));
    }

    private boolean isActiveCourse(int courseId) {
        List<Date> dates = getAllCourseDate(courseId);
        java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
        for (Date date : dates) {
            if (date.after(currentDate) || date.equals(currentDate)) {
                return ACTIVE_COURSE;
            }
        }
        return FINISHED_COURSE;
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
        return new SpecificCourse(((BigDecimal) row.get("id_course")).intValueExact(),
                                    row.get("name").toString(),
                                    new UserName(row.get("last_name").toString(),
                                                row.get("first_name").toString(),
                                                row.get("middle_name").toString()),
                                    row.get("description").toString(),
                                    dates, students);

    }

    private List<Dates> getCourseDates(int courseId) {
        List<Dates> result = new ArrayList<Dates>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_GET_DATES,
                                                        Integer.toString(courseId));

        for (Map<String, Object> row : rows) {
            result.add(getDatesFromMap(row));
        }
        return result;
    }

    private Dates getDatesFromMap(Map<String, Object> row) {
        return new Dates(((BigDecimal) row.get("id_date")).intValueExact(),
                new Date(((Timestamp) row.get("course_date")).getTime()));
    }

    private List<Student> getCourseStudents(int courseId) {
        List<Student> result = new ArrayList<Student>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_GET_STUDENTS, Integer.toString(courseId));

        for (Map<String, Object> row : rows) {
            result.add(getStudentsFromMap(row, courseId));
        }
        return result;
    }

    private Student getStudentsFromMap(Map<String, Object> row, int courseId) {
        int userId = ((BigDecimal) row.get("id_user")).intValueExact();
        return new Student(userId,
                new UserName(row.get("last_name").toString(),
                            row.get("first_name").toString(),
                            row.get("middle_name").toString()),
                FinalGrade.getGradeFromString((String) row.get("final_grade")),
                getProgressList(userId, courseId));
    }

    private List<Progress> getProgressList(int userId, int courseId) {
        List<Progress> result = new ArrayList<Progress>();
        List<Map<String, Object>> rows = this.client.selectData(SQL_GET_PROGRESS,
                                                                Integer.toString(courseId),
                                                                Integer.toString(userId));

        for (Map<String, Object> row : rows) {
            result.add(getProgressFromMap(row));
        }
        return result;
    }

    private Progress getProgressFromMap(Map<String, Object> row) {
        Integer attendance = row.get("attendance") != null ? ((BigDecimal) row.get("attendance")).intValueExact() : null;
        Integer grade = row.get("grade") != null ? ((BigDecimal) row.get("grade")).intValueExact() : null;
        return new Progress(Attendance.getAttendanceFromInt(attendance),
                            Grade.getGradeFromInt(grade));
    }

}
