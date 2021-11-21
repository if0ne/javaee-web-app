package ru.rsreu.javaeewebapp.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class InterimDatesGenerator {

    public static final int START_YEAR = 1900;
    public static final int COUNT_OF_DAYS_IN_WEEK = 7;

    private InterimDatesGenerator() {

    }

    /*public static List<java.sql.Date> getInterimDatesBetween(java.sql.Date begin, java.sql.Date end, int day) {
        List<java.sql.Date> dates = new ArrayList<java.sql.Date>();

        Calendar start = new GregorianCalendar();
        start.setTime(begin);

        Calendar finish = new GregorianCalendar();
        finish.setTime(end);

        int beginDay = start.get(Calendar.DAY_OF_WEEK) - 1;

        //ВОСКРЕСЕНЬЕ В КОНЕЦ НЕДЕЛИ
        if (beginDay == 0) {
            beginDay = 7;
        }

        int dayDiff = day - beginDay;
        start.add(Calendar.DAY_OF_MONTH, dayDiff);
        if (dayDiff >= 0) {
            dates.add(new Date(start.get(Calendar.YEAR) - START_YEAR, start.get(Calendar.MONTH), start.get(Calendar.DAY_OF_MONTH)));
        }

        start.add(Calendar.DAY_OF_MONTH, COUNT_OF_DAYS_IN_WEEK);
        while (start.getTime().before(finish.getTime()) || start.getTime().equals(finish.getTime())) {
            dates.add(new Date(start.get(Calendar.YEAR) - START_YEAR, start.get(Calendar.MONTH), start.get(Calendar.DAY_OF_MONTH)));
            start.add(Calendar.DAY_OF_MONTH, COUNT_OF_DAYS_IN_WEEK);
        }

        return dates;
    }*/


    public static List<java.sql.Date> getInterimDatesBetween(java.sql.Date begin, java.sql.Date end, int day) {
        List<java.sql.Date> dates = new ArrayList<java.sql.Date>();

        LocalDate start = getLocalDateFrom(begin);
        LocalDate finish = getLocalDateFrom(end);

        int beginDay = start.getDayOfWeek().ordinal() + 1;

        int dayDiff = day - beginDay;
        start = start.plusDays(dayDiff);
        if (dayDiff >= 0) {
            dates.add(Date.valueOf(start));
        }

        start= start.plusDays(COUNT_OF_DAYS_IN_WEEK);
        while (start.isBefore(finish) || start.equals(finish)) {
            dates.add(Date.valueOf(start));
            start = start.plusDays(COUNT_OF_DAYS_IN_WEEK);
        }

        return dates;
    }

    private static LocalDate getLocalDateFrom(Date date) {
        return LocalDate.of(START_YEAR + date.getYear(), date.getMonth() + 1, date.getDate());
    }
}
