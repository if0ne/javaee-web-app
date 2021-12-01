package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.DaoFactory;
import ru.rsreu.javaeewebapp.DbType;
import ru.rsreu.javaeewebapp.commands.inputs.UserCourseInfoInput;
import ru.rsreu.javaeewebapp.commands.inputs.UserInfoInput;
import ru.rsreu.javaeewebapp.commands.outputs.ShowStudentDetailedCourseOutput;
import ru.rsreu.javaeewebapp.models.SpecificCourse;
import ru.rsreu.javaeewebapp.models.Student;
import ru.rsreu.javaeewebapp.models.enums.RedirectType;
import ru.rsreu.javaeewebapp.util.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

public class ShowStudentDetailedCourseCommand implements ActionCommand {

    private UserCourseInfoInput input;
    private ShowStudentDetailedCourseOutput output;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {
        input = new UserCourseInfoInput();
        HttpSession session = request.getSession(true);
        input.setUserIdFromRequest(session.getAttribute("userId"));
        input.setCourseIdFromRequest(request.getParameter("course_id"));
    }

    @Override
    public String execute() {
        String page = MessageManager.getProperty("jsp.detailed.fk");
        output = new ShowStudentDetailedCourseOutput();
        SpecificCourse course = DaoFactory.getInstance(DbType.ORACLE).getCoursesDAO().getCourseInformation(input.getCourseId());
        makeUserFirstInList(course.getStudents());
        output.setCourse(course);
        output.setStudentCourses(DaoFactory.getInstance(DbType.ORACLE).getCoursesDAO().getAllStudentCourses(input.getUserId()));
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

    private void makeUserFirstInList(List<Student> list) {
        Student me = list.stream().filter(x -> x.getId() == input.getUserId()).collect(Collectors.toList()).get(0);
        list.remove(me);
        list.add(0, me);
    }

}
