package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.DaoFactory;
import ru.rsreu.javaeewebapp.DbType;
import ru.rsreu.javaeewebapp.commands.inputs.UserCourseInfoInput;
import ru.rsreu.javaeewebapp.commands.outputs.EditCourseOutput;
import ru.rsreu.javaeewebapp.models.Course;
import ru.rsreu.javaeewebapp.models.SpecificCourse;
import ru.rsreu.javaeewebapp.models.TeacherCourse;
import ru.rsreu.javaeewebapp.models.enums.RedirectType;
import ru.rsreu.javaeewebapp.util.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
        String page = MessageManager.getProperty("jsp.edit.fk");
        output = new EditCourseOutput();
        List<TeacherCourse> courses = DaoFactory.getInstance(DbType.ORACLE).getCoursesDAO().getAllTeacherCourses(input.getUserId());
        SpecificCourse course = DaoFactory.getInstance(DbType.ORACLE).getCoursesDAO().getCourseInformation(input.getCourseId());

        output.setCourse(course);
        output.setAllCourses(courses);

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
