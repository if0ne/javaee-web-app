package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.inputs.UserCourseInfoInput;
import ru.rsreu.javaeewebapp.models.enums.RedirectType;
import ru.rsreu.javaeewebapp.util.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class KickFromCourseCommand implements ActionCommand {
    private UserCourseInfoInput input;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {
        input = new UserCourseInfoInput();
        input.setUserIdFromRequest(request.getParameter("user_id"));
        input.setCourseIdFromRequest(request.getParameter("course_id"));
    }

    @Override
    public String execute() {
        String page = MessageManager.getProperty("edit.course.id") + input.getCourseId();
        //TODO: ДАО
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
