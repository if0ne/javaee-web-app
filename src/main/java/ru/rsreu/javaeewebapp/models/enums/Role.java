package ru.rsreu.javaeewebapp.models.enums;

public enum Role {
    ADMINISTRATOR(0, "/controller?command=show_admin_page"),
    MODERATOR(1, "/controller?command=show_mod_page"),
    TEACHER(2, "/controller?command=show_teacher_page"),
    STUDENT(3, "/controller?command=show_student_page"),
    GUEST(4, "/controller?command=show_guest_page");

    private final int role;
    private final String mainPage;

    Role(int role, String mainPage) {
        this.role = role;
        this.mainPage = mainPage;
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
}
