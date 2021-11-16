package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.inputs.UserInfoInput;

import javax.servlet.http.HttpServletRequest;

public class DeleteUserCommand implements ActionCommand {

    private UserInfoInput input;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {
        input = new UserInfoInput();
        input.setUserIdFromRequest(request.getParameter("delete_user_id"));
    }

    @Override
    public String execute() {
        String page = "/controller?command=show_admin_page";
        //TODO: ВЫЗОВ ДАОШКИ ДЛЯ УДАЛЕНИЯ ПОЛЬЗОВАТЕЛЯ
        return page;
    }

    @Override
    public void setAttributes(HttpServletRequest request) {

    }

}
