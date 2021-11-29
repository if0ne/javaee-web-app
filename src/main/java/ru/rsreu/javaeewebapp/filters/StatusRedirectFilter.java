package ru.rsreu.javaeewebapp.filters;

import ru.rsreu.javaeewebapp.commands.CommandEnum;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StatusRedirectFilter implements Filter {

    private List<CommandEnum> accessibleCommands;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        accessibleCommands = new ArrayList<>();
        accessibleCommands.add(CommandEnum.LOGOUT);
        accessibleCommands.add(CommandEnum.SHOW_BLOCKED_PAGE);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(true);

        if (session.getAttribute("status") == null) {
            chain.doFilter(request, response);
            return;
        }

        boolean status = (Boolean) session.getAttribute("status");

        String action = req.getParameter("command");
        CommandEnum commandEnum = CommandEnum.SHOW_BLOCKED_PAGE;
        if (!(action == null || action.isEmpty())) {
            try {
                commandEnum = CommandEnum.valueOf(action.toUpperCase());
            } catch (IllegalArgumentException exception) {
                System.err.println(exception.getMessage());
            }
        }

        if (status) {
            chain.doFilter(request, response);
        } else {
            if (!accessibleCommands.contains(commandEnum)) {
                ((HttpServletResponse) response).sendRedirect("/controller?command=show_blocked_page");
            } else {
                chain.doFilter(request, response);
            }
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
