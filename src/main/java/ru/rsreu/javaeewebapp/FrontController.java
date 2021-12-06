package ru.rsreu.javaeewebapp;

import ru.rsreu.javaeewebapp.commands.ActionCommand;
import ru.rsreu.javaeewebapp.exceptions.CommandException;
import ru.rsreu.javaeewebapp.exceptions.WrongLoginPasswordException;
import ru.rsreu.javaeewebapp.models.enums.RedirectType;
import ru.rsreu.javaeewebapp.util.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * All requests handler
 * Build response depends on request parameters
 * Main parameter - command
 */
public class FrontController extends HttpServlet {

    /**
     * Handle GET-requests
     * @param request - request object
     * @param response - response object
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handle POST-requests
     * @param request - request object
     * @param response - response object
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Recognize what command was called
     * Depends on command executes command logic, defines page for redirect and type of redirect (forward or sendRedirect)
     * @param request - request object
     * @param response - response object
     * @throws ServletException
     * @throws IOException
     */
    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
                                throws ServletException, IOException {
        String page = null;

        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        RedirectType redirectType = command.getRedirectType();

        try {
            command.readRequestAttributes(request);
            page = command.execute();
            command.setAttributes(request);
        } catch (CommandException exception){
            exception.setErrorMessages(request);
            redirectType = RedirectType.FORWARD;
            page = exception.getPage();
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
            redirectType = RedirectType.REDIRECT;
            page = MessageManager.getProperty("show.login");
        }

        switch (redirectType) {
            case REDIRECT:
                response.sendRedirect(page);
                break;
            case FORWARD:
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
                dispatcher.forward(request, response);
                break;
        }
    }
}
