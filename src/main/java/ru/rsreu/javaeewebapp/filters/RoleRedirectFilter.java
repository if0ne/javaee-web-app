package ru.rsreu.javaeewebapp.filters;

import ru.rsreu.javaeewebapp.commands.CommandEnum;
import ru.rsreu.javaeewebapp.models.enums.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleRedirectFilter implements Filter {

    private Map<Role, List<CommandEnum>> roleWithCommand;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        roleWithCommand = new HashMap<Role, List<CommandEnum>>();

        List<CommandEnum> guestCommands = new ArrayList<>();
        guestCommands.add(CommandEnum.LOGIN);
        guestCommands.add(CommandEnum.SHOW_LOGIN);
        guestCommands.add(CommandEnum.SHOW_GUEST_PAGE);
        roleWithCommand.put(Role.GUEST, guestCommands);

        List<CommandEnum> studentCommands = new ArrayList<>();
        studentCommands.add(CommandEnum.SHOW_LOGIN);
        studentCommands.add(CommandEnum.SHOW_STUDENT_PAGE);
        studentCommands.add(CommandEnum.SHOW_STUDENT_DETAILED_COURSE);
        studentCommands.add(CommandEnum.LEAVE_FROM_COURSE);
        studentCommands.add(CommandEnum.SHOW_ALL_COURSES);
        studentCommands.add(CommandEnum.SUBSCRIBE);
        studentCommands.add(CommandEnum.LOGOUT);
        studentCommands.add(CommandEnum.SHOW_BLOCKED_PAGE);
        roleWithCommand.put(Role.STUDENT, studentCommands);

        List<CommandEnum> teacherCommands = new ArrayList<>();
        teacherCommands.add(CommandEnum.SHOW_LOGIN);
        teacherCommands.add(CommandEnum.SHOW_TEACHER_PAGE);
        teacherCommands.add(CommandEnum.SHOW_CREATE_PAGE);
        teacherCommands.add(CommandEnum.CREATE_COURSE);
        teacherCommands.add(CommandEnum.EDIT_COURSE);
        teacherCommands.add(CommandEnum.KICK_FROM_COURSE);
        teacherCommands.add(CommandEnum.UPDATE_USER_GRADE);
        teacherCommands.add(CommandEnum.UPDATE_USER_INFO);
        teacherCommands.add(CommandEnum.LOGOUT);
        teacherCommands.add(CommandEnum.SHOW_BLOCKED_PAGE);
        roleWithCommand.put(Role.TEACHER, teacherCommands);

        List<CommandEnum> modCommands = new ArrayList<>();
        modCommands.add(CommandEnum.SHOW_LOGIN);
        modCommands.add(CommandEnum.LOGOUT);
        modCommands.add(CommandEnum.SHOW_MOD_PAGE);
        modCommands.add(CommandEnum.CHANGE_USER_STATUS);
        modCommands.add(CommandEnum.SHOW_BLOCKED_PAGE);
        roleWithCommand.put(Role.MODERATOR, modCommands);

        List<CommandEnum> adminCommands = new ArrayList<>();
        adminCommands.add(CommandEnum.SHOW_LOGIN);
        adminCommands.add(CommandEnum.LOGOUT);
        adminCommands.add(CommandEnum.SHOW_ADMIN_PAGE);
        adminCommands.add(CommandEnum.CREATE_USER);
        adminCommands.add(CommandEnum.DELETE_USER);
        adminCommands.add(CommandEnum.SHOW_BLOCKED_PAGE);
        roleWithCommand.put(Role.ADMINISTRATOR,adminCommands);
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(true);
        if (session.getAttribute("role") == null) {
            session.setAttribute("user_id", -1);
            session.setAttribute("role", Role.GUEST.toString());
            session.setAttribute("date", new java.util.Date().getTime());
        }

        Role role = Role.valueOf(session.getAttribute("role").toString());

        String action = req.getParameter("command");
        CommandEnum commandEnum = CommandEnum.SHOW_GUEST_PAGE;
        if (!(action == null || action.isEmpty())) {
            try {
                commandEnum = CommandEnum.valueOf(action.toUpperCase());
            } catch (IllegalArgumentException exception) {
                System.err.println(exception.getMessage());
            }
        }

        List<CommandEnum> commands = roleWithCommand.get(role);

        if (commands.contains(commandEnum)) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/controller?command=show_login");
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
