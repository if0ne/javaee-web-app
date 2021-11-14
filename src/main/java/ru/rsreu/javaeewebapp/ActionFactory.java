package ru.rsreu.javaeewebapp;

import ru.rsreu.javaeewebapp.commands.ActionCommand;
import ru.rsreu.javaeewebapp.commands.CommandEnum;
import ru.rsreu.javaeewebapp.commands.EmptyCommand;
import ru.rsreu.javaeewebapp.util.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
        System.out.println("Command: " + action);
        if (action == null || action.isEmpty()) {
            return current;
        }

        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException ex) {
            request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}
