package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.login");

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login == null) {
            return page;
        }

        if (!((login.equals("admin")) && (password.equals("admin")))) {
            request.setAttribute("wrongAction", "Не правильный логин или пароль");
        } else {
            request.setAttribute("wrongAction", null);
        }

        return page;
    }
}
