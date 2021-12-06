package ru.rsreu.javaeewebapp.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateStringConverter {
    private static final SimpleDateFormat STUDENT_DATE_FORMAT =
            new SimpleDateFormat(MessageManager.getProperty("format.date.student"));

    private static final SimpleDateFormat TEACHER_DATE_FORMAT =
            new SimpleDateFormat(MessageManager.getProperty("format.date.teacher"));

    public static String convertDateToStudentString(Date date) {
        return STUDENT_DATE_FORMAT.format(date);
    }

    public static String convertDateToTeacherString(Date date) {
        return TEACHER_DATE_FORMAT.format(date);
    }
}
