package ru.rsreu.javaeewebapp.models.enums;

import ru.rsreu.javaeewebapp.util.MessageManager;

public enum Role {
    ADMINISTRATOR(0, MessageManager.getProperty("show.admin.page"),
                            MessageManager.getProperty("roles.admin")),
    MODERATOR(1, MessageManager.getProperty("show.mod.page"),
                            MessageManager.getProperty("roles.moderator")),
    TEACHER(2, MessageManager.getProperty("show.teacher.page"),
                            MessageManager.getProperty("roles.teacher")),
    STUDENT(3, MessageManager.getProperty("show.student.page"),
                            MessageManager.getProperty("roles.student")),
    GUEST(4, MessageManager.getProperty("show.guest.page"),
                            MessageManager.getProperty("roles.guest"));

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
