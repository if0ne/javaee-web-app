package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.models.enums.RedirectType;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
    void readRequestAttributes(HttpServletRequest request) throws Exception;
    String execute();
    void setAttributes(HttpServletRequest request);
    RedirectType getRedirectType();
}
