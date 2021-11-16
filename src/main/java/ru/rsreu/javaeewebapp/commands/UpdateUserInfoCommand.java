package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.inputs.UpdateUserInfoInput;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UpdateUserInfoCommand implements ActionCommand {

    private UpdateUserInfoInput input;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {
        input = new UpdateUserInfoInput();
        HttpSession session = request.getSession(true);
        input.setCourseId(Integer.parseInt(request.getAttribute("course_id").toString()));
        input.setStudentId(Integer.parseInt(request.getAttribute("student_id").toString()));
        input.setDateId(Integer.parseInt(request.getAttribute("date_id").toString()));
        input.setAttendance(Integer.parseInt(request.getAttribute("attendance").toString()));
        input.setGrade(Integer.parseInt(request.getAttribute("grade").toString()));
    }

    @Override
    public String execute() {
        String page = "/controller?command=edit_course&course_id=" + input.getCourseId();
        return page;
    }

    @Override
    public void setAttributes(HttpServletRequest request) {

    }

}
