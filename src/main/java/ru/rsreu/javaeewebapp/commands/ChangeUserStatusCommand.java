package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.DaoFactory;
import ru.rsreu.javaeewebapp.DbType;
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
        input.setUserStatus(Integer.parseInt(request.getParameter("user_status")));
    }

    @Override
    public String execute() {
        String page = MessageManager.getProperty("show.mod.page");
        int newStatus = input.getUserStatus() == 0 ? 1 : 0;
        DaoFactory.getInstance(DbType.ORACLE).getModifiedUserDAO().updateUserStatus(input.getUserId(), newStatus);
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
