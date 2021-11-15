package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.inputs.MainRedirectInput;
import ru.rsreu.javaeewebapp.models.enums.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MainRedirectCommand implements ActionCommand {

    private MainRedirectInput input;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(true);
        input = new MainRedirectInput();

        Object role = session.getAttribute("role");
        Object userId = session.getAttribute("user_id");

        input.setRole(role == null ? "" : role.toString());
        input.setUserId(userId == null ? -1 : (Integer) userId);
        input.setHasRole(role != null);
    }

    @Override
    public String execute() {
        Role userRole = Role.GUEST;

        if (input.isHasRole()) {
            userRole = Role.valueOf(input.getRole());
        } else {

        }

        return userRole.getMainPage();
    }

    @Override
    public void setAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (!input.isHasRole()) {
            session.setAttribute("user_id", -1);
            session.setAttribute("role", Role.GUEST.toString());
        }
    }
}
