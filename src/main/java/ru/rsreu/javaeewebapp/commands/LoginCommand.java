package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.inputs.LoginInput;
import ru.rsreu.javaeewebapp.commands.outputs.LoginOutput;

import ru.rsreu.javaeewebapp.models.enums.Role;
import ru.rsreu.javaeewebapp.util.ConfigurationManager;
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
    public String execute() {
        String page = "/controller?command=show_login";

        String login = this.input.getLogin();
        String password = this.input.getPassword();

        output = new LoginOutput();

        if (!((login.equals("admin")) && (password.equals("admin")))) {
            output.setSuccessLogin(false);
            output.setWrongLoginPasswordMessage("Неправильный логин или пароль");
        } else {
            output.setSuccessLogin(true);
            output.setUserId(1);
            output.setRole(Role.STUDENT.toString());
            output.setWrongLoginPasswordMessage(null);
        }

        return page;
    }

    @Override
    public void setAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        request.setAttribute("wrong_login_password", output.getWrongLoginPasswordMessage());
        if (output.isSuccessLogin()) {
            session.setAttribute("user_id", output.getUserId());
            session.setAttribute("role", output.getRole());
        }
    }
}
