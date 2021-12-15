package ru.rsreu.javaeewebapp.filters;

import ru.rsreu.javaeewebapp.models.enums.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionLifetimeFilter implements Filter {

    private static final long TIMEOUT = 30*60*1000;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        if (session != null && session.getAttribute("date") != null) {
            long delta = new java.util.Date().getTime() - (Long.parseLong(session.getAttribute("date").toString()));
            if (delta > TIMEOUT) {
                session.setAttribute("role", Role.GUEST.toString());
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
