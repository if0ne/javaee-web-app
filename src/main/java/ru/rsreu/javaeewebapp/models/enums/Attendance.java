package ru.rsreu.javaeewebapp.models.enums;

public enum Attendance {
    PRESENCE(0), REASON(1), SKIPPED(2);

    private int attendance;

    Attendance(int attendance) {
        this.attendance = attendance;
    }

    public static Attendance getAttendanceFromInt(int attendanceId) {
        switch (attendanceId) {
            case 1:
                return REASON;
            case 2:
                return SKIPPED;
            default:
                return PRESENCE;
        }
    }
    public int getAttendance() {
        return this.attendance;
    }
}
