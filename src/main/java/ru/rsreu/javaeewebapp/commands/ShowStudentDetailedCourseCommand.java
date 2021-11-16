package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.inputs.UserCourseInfoInput;
import ru.rsreu.javaeewebapp.commands.inputs.UserInfoInput;
import ru.rsreu.javaeewebapp.commands.outputs.ShowStudentDetailedCourseOutput;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ShowStudentDetailedCourseCommand implements ActionCommand {

    private UserCourseInfoInput input;
    private ShowStudentDetailedCourseOutput output;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {
        input = new UserCourseInfoInput();
        HttpSession session = request.getSession(true);
        input.setUserIdFromRequest(session.getAttribute("user_id"));
        input.setCourseIdFromRequest(request.getParameter("course_id"));
    }

    @Override
    public String execute() {
        String page = "/jsp/detailed_fk.jsp";
        output = new ShowStudentDetailedCourseOutput();
        //TODO: ДАО ДЛЯ ПОЛУЧЕНИЯ ИНФОРМАЦИИ ПРО КУРС
        return null;
    }

    @Override
    public void setAttributes(HttpServletRequest request) {
        request.setAttribute("data", output);
    }

}
