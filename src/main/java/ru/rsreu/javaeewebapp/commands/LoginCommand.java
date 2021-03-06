package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.DaoFactory;
import ru.rsreu.javaeewebapp.DbType;
import ru.rsreu.javaeewebapp.exceptions.WrongLoginPasswordException;
import ru.rsreu.javaeewebapp.commands.inputs.LoginInput;
import ru.rsreu.javaeewebapp.commands.outputs.LoginOutput;

import ru.rsreu.javaeewebapp.models.User;
import ru.rsreu.javaeewebapp.models.enums.RedirectType;
import ru.rsreu.javaeewebapp.models.enums.Role;
import ru.rsreu.javaeewebapp.util.MessageManager;
import ru.rsreu.javaeewebapp.util.ParameterChecker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements ActionCommand {

    private LoginInput input;
    private LoginOutput output;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {
        input = new LoginInput();
        input.setLogin(request.getParameter("login"));
        input.setPassword(request.getParameter("password"));

        boolean isSuccess = !ParameterChecker.isAnyFieldNull(input.getLogin(), input.getPassword());
  
        if (!isSuccess) {
            throw new Exception("Wrong parameters in LoginCommand");
        }
    }

    @Override
    public String execute() throws Exception {
        String page = MessageManager.getProperty("show.login");

        String login = this.input.getLogin();
        String password = this.input.getPassword();

        output = new LoginOutput();

        User user = DaoFactory.getInstance(DbType.ORACLE).getUsersDAO().getLoggedUser(login, password);
        if (user == null) {
            output.setSuccessLogin(false);
            throw new WrongLoginPasswordException("wrongLoginPassword", "Неверный логин или пароль");
        } else {
            Role role = Role.getRoleFromInt(user.getRole());
            output.setSuccessLogin(true);
            output.setUserId(user.getId());
            output.setRole(role.toString());
            output.setRoleName(role.getLocale());
            output.setLastName(user.getLastName());
            output.setFirstName(user.getFirstName());
            output.setStatus(user.getStatus());
            output.setWrongLoginPasswordMessage(null);
        }

        return page;
    }

    @Override
    public void setAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (output.isSuccessLogin()) {
            session.setAttribute("userId", output.getUserId());
            session.setAttribute("role", output.getRole());
            session.setAttribute("roleName", output.getRoleName());
            session.setAttribute("userLastName", output.getLastName());
            session.setAttribute("userFirstName", output.getFirstName());
            session.setAttribute("status", output.getStatus());
            session.setAttribute("date", new java.util.Date().getTime());
        }
    }

    @Override
    public RedirectType getRedirectType() {
        return RedirectType.FORWARD;
    }

}
