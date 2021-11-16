package ru.rsreu.javaeewebapp.commands;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
    public abstract void readRequestAttributes(HttpServletRequest request) throws Exception;
    public abstract String execute();
    public abstract void setAttributes(HttpServletRequest request);
}
