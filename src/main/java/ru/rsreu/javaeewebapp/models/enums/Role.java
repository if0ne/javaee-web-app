package ru.rsreu.javaeewebapp.models.enums;

public enum Role {
    ADMINISTRATOR(0, "/jsp/admin_page.jsp"),
    MODERATOR(1, "/jsp/mod_page.jsp"),
    TEACHER(2, "/jsp/teacher_main.jsp"),
    STUDENT(3, "/jsp/student_main.jsp"),
    GUEST(4, "/jsp/login.jsp");

    private int role;
    private String mainPage;

    Role(int role, String mainPage) {
        this.role = role;
        this.mainPage = mainPage;
    }

    public int getRoleId() {
       return this.role;
    }
    public String getMainPage() { return this.mainPage; }
}
