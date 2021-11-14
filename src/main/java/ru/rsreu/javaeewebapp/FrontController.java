package ru.rsreu.javaeewebapp;

import ru.rsreu.javaeewebapp.commands.ActionCommand;
import ru.rsreu.javaeewebapp.models.enums.Role;
import ru.rsreu.javaeewebapp.util.ConfigurationManager;
import ru.rsreu.javaeewebapp.util.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FrontController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
                                throws ServletException, IOException {
        String page = null;

        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

        page = command.execute(request);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

}
