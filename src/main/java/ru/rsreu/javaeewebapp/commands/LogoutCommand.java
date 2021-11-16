package ru.rsreu.javaeewebapp.commands;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand{

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {

    }

    @Override
    public String execute() {
        String page = "/index.jsp";
        return page;
    }

    @Override
    public void setAttributes(HttpServletRequest request) {
        request.getSession(true).invalidate();
    }
}
