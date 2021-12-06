package ru.rsreu.javaeewebapp.exceptions;

import ru.rsreu.javaeewebapp.util.MessageManager;

public class WrongLoginPasswordException extends CommandException {

    public WrongLoginPasswordException(String key, String message) {
        super(MessageManager.getProperty("jsp.login"), key, message);
    }

}
