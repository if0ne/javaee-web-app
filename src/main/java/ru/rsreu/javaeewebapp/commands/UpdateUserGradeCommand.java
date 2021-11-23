package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.inputs.UpdateUserGradeInput;
import ru.rsreu.javaeewebapp.models.enums.RedirectType;
import ru.rsreu.javaeewebapp.util.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class UpdateUserGradeCommand implements ActionCommand {

    private UpdateUserGradeInput input;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {
        input = new UpdateUserGradeInput();
        input.setCourseId(Integer.parseInt(request.getAttribute("course_id").toString()));
        input.setStudentId(Integer.parseInt(request.getAttribute("student_id").toString()));
        input.setFinalGrade(Integer.parseInt(request.getAttribute("final_grade").toString()));
    }

    @Override
    public String execute() {
        String page = MessageManager.getProperty("edit.course.id") + input.getCourseId();
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
