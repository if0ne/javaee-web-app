package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.outputs.ShowAdminPageOutput;

import javax.servlet.http.HttpServletRequest;

public class ShowGuestPageCommand implements ActionCommand {

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
