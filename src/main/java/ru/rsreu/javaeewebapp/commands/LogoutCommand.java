package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.models.enums.RedirectType;
import ru.rsreu.javaeewebapp.models.enums.Role;
import ru.rsreu.javaeewebapp.util.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand{

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {

    }

    @Override
    public String execute() {
        String page = MessageManager.getProperty("jsp.index");
        return page;
    }

    @Override
    public void setAttributes(HttpServletRequest request) {
        request.getSession(true).setAttribute("role", Role.GUEST.toString());
        request.getSession(true).invalidate();
    }

    @Override
    public RedirectType getRedirectType() {
        return RedirectType.FORWARD;
    }

}
