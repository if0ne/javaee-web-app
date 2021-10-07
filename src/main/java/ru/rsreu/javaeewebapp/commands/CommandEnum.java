package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.ActionCommand;

public enum CommandEnum {
    NONE {};

    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
