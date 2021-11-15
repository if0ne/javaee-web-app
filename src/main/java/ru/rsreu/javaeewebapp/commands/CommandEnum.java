package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.ActionCommand;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    SHOW_LOGIN {
        {
            this.command = new MainRedirectCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
