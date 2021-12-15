package ru.rsreu.javaeewebapp;

import ru.rsreu.javaeewebapp.models.enums.Role;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionListener implements HttpSessionAttributeListener {

    private static final String ATTRIBUTE = "role";
    private static final int GUEST_ID = -1;

    public void attributeReplaced(HttpSessionBindingEvent ev) {
        if (ev.getName().equals(ATTRIBUTE)) {
            HttpSession session = ev.getSession();

            int userId = Integer.parseInt(session.getAttribute("userId").toString());

            if (userId != GUEST_ID) {
                DaoFactory.getInstance(DbType.ORACLE).getModifiedUserDAO().updateLoggedUserStatus(userId, !ev.getValue().equals(Role.GUEST.toString()));
            }
        }
    }
}