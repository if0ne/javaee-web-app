package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.outputs.ShowAdminPageOutput;
import ru.rsreu.javaeewebapp.models.enums.RedirectType;
import ru.rsreu.javaeewebapp.util.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class ShowGuestPageCommand implements ActionCommand {

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {

    }

    @Override
    public String execute() {
        String page = MessageManager.getProperty("jsp.login");
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
