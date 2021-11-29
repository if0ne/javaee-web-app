package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.models.enums.RedirectType;
import ru.rsreu.javaeewebapp.util.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class ShowBlockedPageCommand implements ActionCommand {
    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {

    }

    @Override
    public String execute() {
        String page = MessageManager.getProperty("jsp.blocked");
        return page;
    }

    @Override
    public void setAttributes(HttpServletRequest request) {

    }

    @Override
    public RedirectType getRedirectType() {
        return RedirectType.FORWARD;
    }
}
