package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.DaoFactory;
import ru.rsreu.javaeewebapp.DbType;
import ru.rsreu.javaeewebapp.commands.inputs.UserInfoInput;
import ru.rsreu.javaeewebapp.models.enums.RedirectType;
import ru.rsreu.javaeewebapp.util.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class DeleteUserCommand implements ActionCommand {

    private UserInfoInput input;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {
        input = new UserInfoInput();
        input.setUserIdFromRequest(request.getParameter("delete_user_id"));
    }

    @Override
    public String execute() {
        String page = MessageManager.getProperty("show.admin.page");
        DaoFactory.getInstance(DbType.ORACLE).getModifiedUserDAO().deleteUser(input.getUserId());
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
