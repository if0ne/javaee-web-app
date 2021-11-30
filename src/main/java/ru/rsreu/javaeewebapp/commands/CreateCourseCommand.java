package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.DaoFactory;
import ru.rsreu.javaeewebapp.DbType;
import ru.rsreu.javaeewebapp.commands.inputs.CreateCourseInput;
import ru.rsreu.javaeewebapp.models.enums.RedirectType;
import ru.rsreu.javaeewebapp.util.InterimDatesGenerator;
import ru.rsreu.javaeewebapp.util.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class CreateCourseCommand implements ActionCommand {

    private CreateCourseInput input;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {
        input = new CreateCourseInput();
        HttpSession session = request.getSession(true);
        input.setTeacherId(Integer.parseInt(session.getAttribute("userId").toString()));
        input.setDay(Integer.parseInt(request.getParameter("day")));
        input.setTitle(request.getParameter("title"));
        input.setDescription(request.getParameter("description"));
        input.setBeginDate(Date.valueOf(request.getParameter("begin")));
        input.setEndDate(Date.valueOf(request.getParameter("end")));
    }

    @Override
    public String execute() {
        String page = MessageManager.getProperty("show.teacher.page");
        DaoFactory.getInstance(DbType.ORACLE).getModifiedCourseDAO().createCourse(
                input.getTeacherId(),
                input.getTitle(),
                input.getDescription(),
                InterimDatesGenerator.getInterimDatesBetween(input.getBeginDate(),
                                                                input.getEndDate(),
                                                                input.getDay())
        );
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
