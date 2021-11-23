package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.inputs.UserInfoInput;
import ru.rsreu.javaeewebapp.models.enums.RedirectType;
import ru.rsreu.javaeewebapp.util.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class ChangeUserStatusCommand implements ActionCommand {

    private UserInfoInput input;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {
        input = new UserInfoInput();
        input.setUserIdFromRequest(request.getParameter("user_id"));
    }

    @Override
    public String execute() {
        String page = MessageManager.getProperty("show.mod.page");
        return page;
    }

    @Override
    public void setAttributes(HttpServletRequest request) {

    }

    @Override
    public RedirectType getRedirectType() {
        return RedirectType.REDIRECT;
    }

}
