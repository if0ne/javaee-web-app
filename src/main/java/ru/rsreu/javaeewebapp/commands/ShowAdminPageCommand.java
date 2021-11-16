package ru.rsreu.javaeewebapp.commands;

import ru.rsreu.javaeewebapp.commands.outputs.ShowAdminPageOutput;

import javax.servlet.http.HttpServletRequest;

public class ShowAdminPageCommand implements ActionCommand {

    private ShowAdminPageOutput output;

    @Override
    public void readRequestAttributes(HttpServletRequest request) throws Exception {

    }

    @Override
    public String execute() {
        String page = "/jsp/admin_page.jsp";
        output = new ShowAdminPageOutput();
        return page;
    }

    @Override
    public void setAttributes(HttpServletRequest request) {
        request.setAttribute("data", output);
    }
}
