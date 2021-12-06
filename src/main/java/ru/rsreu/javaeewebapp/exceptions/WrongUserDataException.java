package ru.rsreu.javaeewebapp.exceptions;

import ru.rsreu.javaeewebapp.util.MessageManager;

public class WrongUserDataException extends CommandException {

    public WrongUserDataException(String key, String message) {
        super(MessageManager.getProperty("show.admin.page"), key, message);
    }

}
