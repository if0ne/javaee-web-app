package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.models.enums.Role;
import ru.rsreu.javaeewebapp.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MainRedirectCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.login");

        HttpSession session = request.getSession(true);

        if (session.getAttribute("user_id") == null) {
            session.setAttribute("user_id", -1);
            session.setAttribute("role", Role.GUEST.toString());
        }

        Role userRole = Role.valueOf(session.getAttribute("role").toString());

        return userRole.getMainPage();
    }
}
