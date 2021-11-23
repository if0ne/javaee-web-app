package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.DaoFactory;
import ru.rsreu.javaeewebapp.DbType;
import ru.rsreu.javaeewebapp.commands.outputs.ShowAdminPageOutput;
import ru.rsreu.javaeewebapp.models.UserRole;
import ru.rsreu.javaeewebapp.models.enums.RedirectType;
import ru.rsreu.javaeewebapp.util.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowAdminPageCommand implements ActionCommand {

    private ShowAdminPageOutput output;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {

    }

    @Override
    public String execute() {
        String page = MessageManager.getProperty("jsp.admin");
        output = new ShowAdminPageOutput();

        List<UserRole> users = DaoFactory.getInstance(DbType.ORACLE).getUsersDAO().getAllUsersRoles();
        output.setAllUsers(users);

        return page;
    }

    @Override
    public void setAttributes(HttpServletRequest request) {
        request.setAttribute("data", output);
    }

    @Override
    public RedirectType getRedirectType() {
        return RedirectType.FORWARD;
    }

}
