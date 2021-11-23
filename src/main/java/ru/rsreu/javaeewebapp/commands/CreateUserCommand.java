package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.DaoFactory;
import ru.rsreu.javaeewebapp.DbType;
import ru.rsreu.javaeewebapp.commands.inputs.CreateUserInput;
import ru.rsreu.javaeewebapp.models.enums.RedirectType;
import ru.rsreu.javaeewebapp.models.enums.Role;
import ru.rsreu.javaeewebapp.util.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class CreateUserCommand implements ActionCommand {

    private CreateUserInput input;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {
        input = new CreateUserInput();
        input.setFirstName(request.getParameter("first_name"));
        input.setLastName(request.getParameter("last_name"));

        String middleName = request.getParameter("middle_name");
        input.setMiddleName(middleName.trim().equals("") ? null : middleName);
        input.setLogin(request.getParameter("user_login"));
        input.setPassword(request.getParameter("user_password"));
        int roleId = Integer.parseInt(request.getParameter("new_user_role"));
        input.setRole(Role.getRoleFromInt(roleId));
    }

    @Override
    public String execute() {
        String page = MessageManager.getProperty("show.admin.page");
        DaoFactory.getInstance(DbType.ORACLE).getModifiedUserDAO().createUser(
                input.getLastName(),
                input.getFirstName(),
                input.getMiddleName(),
                input.getLogin(),
                input.getPassword(),
                input.getRole().getRoleId()
        );
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
