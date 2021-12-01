package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.DaoFactory;
import ru.rsreu.javaeewebapp.DbType;
import ru.rsreu.javaeewebapp.commands.inputs.UpdateUserInfoInput;
import ru.rsreu.javaeewebapp.models.enums.RedirectType;
import ru.rsreu.javaeewebapp.util.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UpdateUserInfoCommand implements ActionCommand {

    private UpdateUserInfoInput input;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {
        input = new UpdateUserInfoInput();

        input.setCourseId(Integer.parseInt(request.getParameter("course_id").toString()));
        input.setStudentId(Integer.parseInt(request.getParameter("student_id").toString()));
        input.setDateId(Integer.parseInt(request.getParameter("date_id").toString()));
        input.setAttendance(Integer.parseInt(request.getParameter("attendance").toString()));
        input.setGrade(Integer.parseInt(request.getParameter("grade").toString()));
    }

    @Override
    public String execute() {
        String page = MessageManager.getProperty("edit.course.id") + input.getCourseId();
        DaoFactory.getInstance(DbType.ORACLE).getProgressDAO().updateStudentProgress(input.getStudentId(),
                input.getCourseId(), input.getDateId(), input.getAttendance(), input.getGrade());
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
