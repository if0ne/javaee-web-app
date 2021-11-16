package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.inputs.UserCourseInfoInput;
import ru.rsreu.javaeewebapp.commands.outputs.EditCourseOutput;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EditCourseCommand implements ActionCommand {

    private UserCourseInfoInput input;
    private EditCourseOutput output;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {
        input = new UserCourseInfoInput();
        HttpSession session = request.getSession(true);
        input.setUserIdFromRequest(session.getAttribute("user_id"));
        input.setCourseIdFromRequest(request.getParameter("course_id"));
    }

    @Override
    public String execute() {
        String page = "/jsp/edit_fk.jsp";
        output = new EditCourseOutput();
        //TODO: ДАО
        return page;
    }

    @Override
    public void setAttributes(HttpServletRequest request) {
        request.setAttribute("data", output);
    }

}
