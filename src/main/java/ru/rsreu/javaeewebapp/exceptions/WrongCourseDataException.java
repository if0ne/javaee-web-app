package ru.rsreu.javaeewebapp.exceptions;

import ru.rsreu.javaeewebapp.util.MessageManager;

public class WrongCourseDataException extends CommandException {

    public WrongCourseDataException() {
        super(MessageManager.getProperty("show.create.page"), "", "");
    }

}
