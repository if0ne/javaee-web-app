package ru.rsreu.javaeewebapp.commands;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {

    },
    CREATE_USER {

    },
    DELETE_USER {

    },
    SHOW_MY_COURSES {

    },
    SUBSCRIBE {

    },
    SHOW_DETAILED_COURSE {

    },
    CREATE_COURSE {

    },
    LEAVE_FROM_COURSE {

    },
    UPDATE_USER_INFO {

    },
    UPDATE_USER_GRADE {

    },
    CHANGE_USER_STATUS {

    },
    SHOW_ALL_COURSES {

    },
    EDIT_COURSE {

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