package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.ActionCommand;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
