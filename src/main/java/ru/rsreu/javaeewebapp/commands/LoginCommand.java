package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.models.enums.Role;
import ru.rsreu.javaeewebapp.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/controller?command=show_login";

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login == null) {
            return page;
        }

        if (!((login.equals("admin")) && (password.equals("admin")))) {
            request.setAttribute("wrong_login_password", "Не правильный логин или пароль");
        } else {
            request.getSession(true).setAttribute("user_id", 1);
            request.getSession(true).setAttribute("role", Role.STUDENT.toString());
            request.setAttribute("wrong_login_password", null);
        }

        return page;
    }
}
