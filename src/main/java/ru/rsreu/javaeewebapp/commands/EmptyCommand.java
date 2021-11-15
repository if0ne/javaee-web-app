package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand{

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {

    }

    @Override
    public String execute() {
        String page = "/controller?command=show_login";
        return page;
    }

    @Override
    public void setAttributes(HttpServletRequest request) {

    }
}
