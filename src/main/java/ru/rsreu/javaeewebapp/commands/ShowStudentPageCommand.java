package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.inputs.UserInfoInput;
import ru.rsreu.javaeewebapp.commands.outputs.ShowStudentPageOutput;
import ru.rsreu.javaeewebapp.models.enums.RedirectType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ShowStudentPageCommand implements ActionCommand {

    private UserInfoInput input;
    private ShowStudentPageOutput output;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {
        input = new UserInfoInput();
        HttpSession session = request.getSession(true);
        input.setUserIdFromRequest(session.getAttribute("user_id"));
    }

    @Override
    public String execute() {
        String page = "/jsp/student_main.jsp";
        output = new ShowStudentPageOutput();

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
