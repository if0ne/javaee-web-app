package ru.rsreu.javaeewebapp.commands;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    CREATE_USER {
        {
            this.command = new CreateUserCommand();
        }
    },
    DELETE_USER {
        {
            this.command = new DeleteUserCommand();
        }

    },
    SHOW_STUDENT_PAGE {
        {
            this.command = new ShowStudentPageCommand();
        }
    },
    SHOW_STUDENT_DETAILED_COURSE {
        {
            this.command = new ShowStudentDetailedCourseCommand();
        }
    },
    SHOW_ALL_COURSES {
        {
            this.command = new ShowAllCoursesCommand();
        }
    },
    SUBSCRIBE {
        {
            this.command = new SubscribeCommand();
        }
    },
    LEAVE_FROM_COURSE {
        {
            this.command = new LeaveFromCourseCommand();
        }
    },
    SHOW_TEACHER_PAGE {
        {
            this.command = new ShowTeacherPageCommand();
        }
    },
    SHOW_CREATE_PAGE {
        {
            this.command = new ShowCreatePageCommand();
        }
    },
    CREATE_COURSE {
        {
            this.command = new CreateCourseCommand();
        }
    },
    UPDATE_USER_INFO {
        {
            this.command = new UpdateUserInfoCommand();
        }
    },
    UPDATE_USER_GRADE {
        {
            this.command = new UpdateUserGradeCommand();
        }
    },
    CHANGE_USER_STATUS {
        {
            this.command = new ChangeUserStatusCommand();
        }
    },
    EDIT_COURSE {
        {
            this.command = new EditCourseCommand();
        }
    },
    SHOW_LOGIN {
        {
            this.command = new MainRedirectCommand();
        }
    },
    KICK_FROM_COURSE {
        {
            this.command = new KickFromCourseCommand();
        }
    },
    SHOW_ADMIN_PAGE {
        {
            this.command = new ShowAdminPageCommand();
        }
    },
    SHOW_MOD_PAGE {
        {
            this.command = new ShowModPageCommand();
        }
    },
    SHOW_GUEST_PAGE {
        {
            this.command = new ShowGuestPageCommand();
        }
    },
    SHOW_BLOCKED_PAGE {
        {
            this.command = new ShowBlockedPageCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}