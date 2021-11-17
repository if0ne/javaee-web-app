package ru.rsreu.javaeewebapp.models.enums;

public enum Role {
    ADMINISTRATOR(0, "/controller?command=show_admin_page", "Администратор"),
    MODERATOR(1, "/controller?command=show_mod_page", "Модератор"),
    TEACHER(2, "/controller?command=show_teacher_page", "Преподаватель"),
    STUDENT(3, "/controller?command=show_student_page", "Студент"),
    GUEST(4, "/controller?command=show_guest_page", "Гость");

    private final int role;
    private final String mainPage;
    private final String locale;

    Role(int role, String mainPage, String locale) {
        this.role = role;
        this.mainPage = mainPage;
        this.locale = locale;
    }

    public static Role getRoleFromInt(int roleId) {
        for (Role role : Role.values()) {
            if (roleId == role.getRoleId()) {
                return role;
            }
        }
        return Role.GUEST;
    }

    public int getRoleId() {
       return this.role;
    }
    public String getMainPage() { return this.mainPage; }
    public String getLocale() { return this.locale; }
}
