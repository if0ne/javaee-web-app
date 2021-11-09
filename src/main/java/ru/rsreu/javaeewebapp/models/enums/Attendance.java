package ru.rsreu.javaeewebapp.models.enums;

public enum Attendance {
    PRESENCE(0), REASON(1), PASS(2);

    private int attendance;

    Attendance(int attendance) {
        this.attendance = attendance;
    }

    public int getAttendance() {
        return this.attendance;
    }
}
