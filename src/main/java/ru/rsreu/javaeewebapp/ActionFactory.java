package ru.rsreu.javaeewebapp;

import ru.rsreu.javaeewebapp.commands.ActionCommand;
import ru.rsreu.javaeewebapp.commands.EmptyCommand;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }

        try {

        } catch (IllegalArgumentException ex) {
            request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}
