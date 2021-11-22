package ru.rsreu.javaeewebapp.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateStringConverter {
    private static final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat(MessageManager.getProperty("format.date"));

    public static String convertDateToString(Date date) {
        return DATE_FORMAT.format(date);
    }
}