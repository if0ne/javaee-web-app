package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.inputs.UpdateUserGradeInput;

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
        String page = "/controller?command=edit_course&course_id=" + input.getCourseId();
        return page;
    }

    @Override
    public void setAttributes(HttpServletRequest request) {

    }

}
