package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand{

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {

    }

    @Override
    public String execute() {
        String page = "/jsp/login.jsp";
        return page;
    }

    @Override
    public void setAttributes(HttpServletRequest request) {

    }
}
